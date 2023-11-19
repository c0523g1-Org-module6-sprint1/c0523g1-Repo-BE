package com.dating.dto.account;

import com.dating.commons.account.ValidateAccount;
import com.dating.model.Role;
import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.dating.model.message.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto implements Validator {
    private Integer id;
//    private String name;
    private String userName;
    private String password;
    private String birthday;
    private String email;
//    private String phoneNumber;
//    private Double money;
//    private String regisDate;
//    private String avatar;
//    private String expire;
//    private String maritalStatus;
//    private Integer point;
//    private Integer genderId;
//    private Integer jobId;
//    private Integer roleId;
//    private Integer locationId;
//    private Integer hobbyId;
    private Integer gender;
    private Integer job;
//    private Integer role;
    private Integer location;
//    private Hobby hobby;
//    private MessageStatus messageStatus;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
        ValidateAccount.checkValidateAccountUserName(accountDto.getUserName(),errors);
        ValidateAccount.checkValidateAccountPassword(accountDto.getPassword(), errors);
        ValidateAccount.checkValidateAccountEmail(accountDto.getEmail(), errors);
        ValidateAccount.checkValidateAccountBirthday(accountDto.getBirthday(),errors);
    }
}
