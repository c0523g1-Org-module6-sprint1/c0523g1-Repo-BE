package com.dating.dto;

import com.dating.model.Role;
import com.dating.validation.LoginRequestValidation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto implements Validator {

    private Integer id;
    private String userName;
    private String password;
    private Role role;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginRequestDto loginRequestDto = (LoginRequestDto) target;
        LoginRequestValidation.usernameValidator(loginRequestDto.getUserName(), errors);
        LoginRequestValidation.usernameValidator(loginRequestDto.getPassword(), errors);
    }
}
