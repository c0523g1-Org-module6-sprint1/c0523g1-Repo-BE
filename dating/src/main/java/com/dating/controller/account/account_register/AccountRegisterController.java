package com.dating.trivn_controller.account.account_register;

import com.dating.dto.account.AccountDto;
import com.dating.model.Role;
import com.dating.model.account.Account;
import com.dating.service.account.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class AccountRegisterController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IAccountService accountService;

    /**
     * method login
     * create by SangPQ
     * date 13-11-2023
     * param AccountDto accountDto,BindingResult bindingResult
     * return ResponseEntity
     */
    @PostMapping("/register")
    public ResponseEntity<Object> login(@Valid @RequestBody AccountDto accountDto, BindingResult bindingResult) {
        new AccountDto().validate(accountDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().stream().map(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
            return new ResponseEntity<>(errorMap, HttpStatus.OK);
        }
        Account accountUserName = accountService.findByUsername(accountDto.getUserName());
        Account accountEmail = accountService.findByEmail(accountDto.getEmail());
        if (accountUserName != null) {
            return new ResponseEntity<>("Tên đăng nhập đã tồn tại", HttpStatus.OK);
        } else if (accountEmail != null) {
            return new ResponseEntity<>("Email đã tồn tại", HttpStatus.OK);
        } else {
            Account account = new Account();
//            newAccount.setUserName(accountDto.getUserName());
//            newAccount.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//            newAccount.setBirthday(accountDto.getBirthday());
//            newAccount.setEmail(accountDto.getEmail());
//            Gender gender = accountService.findGender(accountDto.getGenderId());
//            Location location = accountService.findLocation(accountDto.getLocationId());
//            Job job = accountService.findJob(accountDto.getJobId());
//            newAccount.setGender(gender);
//            newAccount.setLocation(location);
//            newAccount.setJob(job);
//            Boolean checkAddNewAccount = accountService.createNewAccount(newAccount,"ROLE_MEMBER");
//            if (!Boolean.TRUE.equals(checkAddNewAccount)) {
//                return new ResponseEntity<>("Đăng kí thất bại, vui lòng thử lại", HttpStatus.OK);
//            }
//            return new ResponseEntity<>(newAccount, HttpStatus.ACCEPTED);
            BeanUtils.copyProperties(accountDto,account);
            account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
            Role role = new Role();
            role.setId(2);
            account.setRole(role);
            accountService.createNewAccount(account);
            return new ResponseEntity<>(account,HttpStatus.ACCEPTED);

        }
    }

//    @PostMapping("/initial-information")
//    public ResponseEntity<Object> initInfo(@Valid @RequestBody AccountDto accountDto, BindingResult bindingResult){
//        new AccountDto().validate(accountDto,bindingResult);
//        Map<String, String> errorMap = new HashMap<>();
//        if (bindingResult.hasErrors()) {
//            bindingResult.getFieldErrors().stream().map(fieldError -> errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
//            return new ResponseEntity<>(errorMap, HttpStatus.OK);
//        }
//        Account initAccount = new Account();
//        BeanUtils.copyProperties(accountDto,initAccount);
//    }
}
