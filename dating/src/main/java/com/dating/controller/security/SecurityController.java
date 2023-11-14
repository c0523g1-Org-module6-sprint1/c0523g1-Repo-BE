package com.dating.controller.security;


import com.dating.config.JwtTokenUtil;
import com.dating.dto.LoginRequestDto;
import com.dating.payload.request.LoginRequest;
import com.dating.payload.response.JwtResponse;
import com.dating.service.security.JwtUserDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public")
public class SecurityController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    /**
     * method authenticationUser
     * Create ThienBB
     * Date 13-11-2023
     * param LoginRequestDto
     * return JwtResponse
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequestDto loginRequestDto,
                                                BindingResult bindingResult) throws Exception {
        new LoginRequestDto().validate(loginRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        LoginRequest loginRequest = new LoginRequest();
        BeanUtils.copyProperties(loginRequestDto, loginRequest);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getUserName(), loginRequestDto.getPassword()
            ));
        } catch (DisabledException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(loginRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * method: Logout
     * Create ThienBB
     * Date 14-11-2023
     * param String username
     * return void
     */
    @GetMapping("/logout/{username}")
    public ResponseEntity<Object> logout(@PathVariable String username) {
        return ResponseEntity.ok(new JwtResponse(null));
    }

}
