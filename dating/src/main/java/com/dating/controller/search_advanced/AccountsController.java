package com.dating.HauNH_controller.search_advanced;

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
@RequestMapping("/api/search_advanced")
public class AccountsController {
    @Autowired
    private IAccountsService accountsService;

    @GetMapping("")
    public ResponseEntity<List<Account>> getAll(String name, String birthday, int genderId, int hobbyId, int locationId, int jobId, int hobbyDetailId) {
        List<Account> accounts = accountsService.getAll(name, birthday, genderId, hobbyId, locationId, jobId, hobbyDetailId);
        if (accounts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accounts, HttpStatus.OK);
        }
    }
}
