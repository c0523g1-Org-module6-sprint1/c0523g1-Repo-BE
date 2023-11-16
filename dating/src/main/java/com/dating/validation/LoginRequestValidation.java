package com.dating.validation;

import org.springframework.validation.Errors;

public class LoginRequestValidation {
    private LoginRequestValidation() {
        throw new IllegalStateException("Utility class");
    }

    private static final String EMPTY = "Trường này không được để trống";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";

    public static void usernameValidator(String username, Errors errors) {
        if (username == null || username.trim().length() == 0) {
            errors.rejectValue(USER_NAME, "", EMPTY);
        }
    }


    public static void passwordValidator(String password, Errors errors) {
        if (password == null || password.trim().length() == 0) {
            errors.rejectValue(PASSWORD, "", EMPTY);
        }
    }

}
