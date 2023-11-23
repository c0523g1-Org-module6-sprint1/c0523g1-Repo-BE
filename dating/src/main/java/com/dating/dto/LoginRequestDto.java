package com.dating.dto;


import com.dating.validation.LoginRequestValidation;

import lombok.Getter;

import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Setter
@Getter
public class LoginRequestDto implements Validator {

    private static final long serialVersionUID = 5926469583028550707L;

    private String username;
    private String password;

    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequestDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    /**
     * method validate()
     * Create ThienBB
     * Date 13-11-2023
     * param Object target, Errors errors
     * return void
     */
    @Override
    public void validate(Object target, Errors errors) {
        LoginRequestDto loginRequestDto = (LoginRequestDto) target;
        LoginRequestValidation.usernameValidator(loginRequestDto.getUsername(), errors);
        LoginRequestValidation.usernameValidator(loginRequestDto.getPassword(), errors);
    }
}
