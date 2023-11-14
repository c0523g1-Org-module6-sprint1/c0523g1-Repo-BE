package com.dating.controller.account;

import com.dating.model.account.Account;
import com.dating.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/accounts")
    public ResponseEntity<Page<Account>> showAccountList(
                                                         @RequestParam(value = "_page", defaultValue = "1") int page,
                                                         @RequestParam(value = "username_like", defaultValue = "") String username
                                                          ) {
        Pageable pageable = PageRequest.of(page , 2);
        Page<Account> accountList = iAccountService.findAll(pageable, username);
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }


//    @PatchMapping("/personal-page/edit/{id}")
//    @ResponseBody
//    public ResponseEntity<Object> updateAccount(@Valid @ResponseBody AccountDto accountDto, BindingResult bindingResult){
//        new AccountDto
//    }
}
