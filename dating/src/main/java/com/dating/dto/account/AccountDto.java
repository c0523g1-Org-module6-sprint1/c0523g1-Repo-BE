package com.dating.dto.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Validator {
    private Integer id;
    private String name;
    private String userName;
    private String password;
    private String birthday;
    private String email;
    private String phoneNumber;
    private Double money;
    private String regisDate;
    private String avatar;
    private String expire;
    private String maritalStatus;
    private Integer point;
    private Integer genderId;
    private Integer jobId;
    private Integer roleId;
    private Integer locationId;
    private Integer messageStatusId;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
    }
}
