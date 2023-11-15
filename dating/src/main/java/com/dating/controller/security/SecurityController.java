package com.dating.trivn_controller.security;


import com.dating.config.JwtTokenUtil;
import com.dating.dto.LoginRequestDto;
import com.dating.model.account.Account;
import com.dating.payload.request.LoginRequest;
import com.dating.payload.response.JwtResponse;
import com.dating.service.security.ISecurityService;
import com.dating.service.security.impl.JwtUserDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * method authenticationUser
     * Create ThienBB
     * Date 13-11-2023
     * param LoginRequestDto
     * return JwtResponse
     */
    @PostMapping("/login")
    public ResponseEntity<Object> authenticationUser(@Valid @RequestBody LoginRequestDto loginRequestDto,
                                                     BindingResult bindingResult) throws Exception {
        new LoginRequestDto().validate(loginRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        LoginRequest loginRequest = new LoginRequest();
        BeanUtils.copyProperties(loginRequestDto, loginRequest);

        try {
            Account account = this.
                    securityService.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException());

            if (account != null) {
//                passwordEncoder.matches(loginRequestDto.getPassword(), account.getPassword())
                if (account.getPassword().contains(loginRequest.getPassword())) {
                    UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(account.getUserName());
                    String jwtToken = jwtTokenUtil.generateToken(userDetails);
                    return ResponseEntity.ok().body(new JwtResponse(jwtToken));
                } else {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println("Exception while get account by username - controller method");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
