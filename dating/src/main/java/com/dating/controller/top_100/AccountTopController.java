package com.dating.controller.top_100;

import com.dating.dto.top_100.TopHunderedDto;
import com.dating.model.account.Account;
import com.dating.service.search_advanced_top_100.IAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/top_hundered")
public class AccountTopController {
    @Autowired
    private IAccountsService accountsService;

    @GetMapping("")
    public ResponseEntity<List<TopHunderedDto>> getAll() {
        List<TopHunderedDto> accounts = accountsService.findAll();
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
    }
}
