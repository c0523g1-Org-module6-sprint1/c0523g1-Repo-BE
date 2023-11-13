package com.dating.commons.account;

import org.springframework.security.access.method.P;
import org.springframework.validation.Errors;

public class ValidateAccount {
    private ValidateAccount(){
        throw new IllegalArgumentException("Utility Class");
    }
    private static final String NAME_NOT_EMPTY = "Không để trống tên đăng nhập";
    private static final String PASSWORD_NOT_EMPTY = "Không để trống mật khẩu";
    private static final String CHAR_LENGTH_LESS_SIX = "Số lượng ký tự phải lớn hơn hoặc bằng 6";
    private static final String CHAR_LENGTH_GREATER_HUNDRED = "Số lượng ký tự bé hơn hoặc bằng 100";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String EMAIL_REGEX  = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final String CONFIRM_PASSWORD = "confirmPassword";

    public static void checkValidateAccountUserName(String name, Errors errors){
        if (name == null || name.trim().length() == 0){
            errors.rejectValue(USER_NAME,"",NAME_NOT_EMPTY);
        } else if (name.length() > 100) {
            errors.rejectValue(USER_NAME,"",CHAR_LENGTH_GREATER_HUNDRED);
        } else if (name.length() < 6) {
            errors.rejectValue(USER_NAME,"",CHAR_LENGTH_LESS_SIX);
        }
    }

    public static void checkValidateAccountPassword(String password,Errors errors){
        if (password == null || password.trim().length() == 0){
            errors.rejectValue(PASSWORD,"",PASSWORD_NOT_EMPTY);
        } else if (password.length() > 100) {
            errors.rejectValue(PASSWORD,"",CHAR_LENGTH_GREATER_HUNDRED);
        } else if (password.length() < 6) {
            errors.rejectValue(PASSWORD,"",CHAR_LENGTH_LESS_SIX);
        }
    }
    public static void checkValidateAccountEmail(String email,Errors errors){
        if (email == null){
            errors.rejectValue(EMAIL,"","Vui lòng bổ sung email");
        } else if (email.trim().equals("")) {
            errors.rejectValue(EMAIL,"","Vui lòng nhập email");
        } else if (email.length() < 6) {
            errors.rejectValue(EMAIL,"",CHAR_LENGTH_LESS_SIX);
        } else if (email.length() > 100) {
            errors.rejectValue(EMAIL,"",CHAR_LENGTH_GREATER_HUNDRED);
        } else if (!email.matches(EMAIL_REGEX)) {
            errors.rejectValue(EMAIL,"","Bạn đã nhập sai định dạng email");
        }
    }
}
