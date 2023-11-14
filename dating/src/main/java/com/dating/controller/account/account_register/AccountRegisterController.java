package com.dating.trivn_controller.account.account_register;

import com.dating.dto.account.AccountDto;
import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import com.dating.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AccountRegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IAccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<Object> login(@Valid @RequestBody AccountDto accountDto, BindingResult bindingResult) {
        new AccountDto().validate(accountDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().stream()
                    .map(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.OK);
        }
        Account accountUserName = accountService.findByUsername(accountDto.getUserName());
        Account accountEmail = accountService.findByEmail(accountDto.getEmail());
        if (accountUserName != null){
            return new ResponseEntity<>("Tên đăng nhập đã tồn tại",HttpStatus.OK);
        } else if (accountEmail != null) {
            return new ResponseEntity<>("Email đã tồn tại",HttpStatus.OK);
        }else {
            Account newAccount = new Account();
            newAccount.setUserName(accountDto.getUserName());
            newAccount.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            newAccount.setBirthday(accountDto.getBirthday());
            newAccount.setEmail(accountDto.getEmail());
            Gender gender = accountService.findGender(accountDto.getGenderId());
            Location location = accountService.findLocation(accountDto.getLocationId());
            Job job = accountService.findJob(accountDto.getJobId());
            newAccount.setGender(gender);
            newAccount.setLocation(location);
            newAccount.setJob(job);
            Boolean checkAddNewAccount = accountService.createNewAccount(newAccount);
            if (!Boolean.TRUE.equals(checkAddNewAccount)){
                return new ResponseEntity<>("Đăng kí thất bại, vui lòng thử lại",HttpStatus.OK);
            }
            return new ResponseEntity<>(newAccount,HttpStatus.ACCEPTED);
        }
    }
}
