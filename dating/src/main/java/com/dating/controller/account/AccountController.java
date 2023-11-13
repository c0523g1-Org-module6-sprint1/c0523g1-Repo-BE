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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping()
public class AccountController {
    @Autowired
    private IAccountService iAccountService;

    @GetMapping("api/admin/accounts")
    public ResponseEntity<Page<Account>> showAccountList(
                                                         @RequestParam(name = "_page", defaultValue = "1") int page,
                                                         @RequestParam(name = "username_like", defaultValue = "") String username,
                                                         @RequestParam(name = "_limit", defaultValue = "5") int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Account> accountList = iAccountService.findAll(pageable, username);
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

}
