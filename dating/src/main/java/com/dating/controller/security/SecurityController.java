package com.dating.controller.security;


import com.dating.jwt.JwtUtility;
import com.dating.payload.request.LoginRequest;
import com.dating.payload.response.JwtResponse;
import com.dating.service.impl.AccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping()
    public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtility.JwtTokenGenerator(loginRequest.getUsername());
        AccountDetail accountDetail = (AccountDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = accountDetail.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()).toString();

        return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        accountDetail.getId(),
                        accountDetail.getUsername(),
                        role
                )
        );
    }
}
