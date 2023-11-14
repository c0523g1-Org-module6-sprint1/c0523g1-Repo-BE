package com.dating.controller.top_100;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/top_hundered")
public class AccountTopController {
//    @Autowired
//    private IAccountsService accountsService;
//
//    @GetMapping("")
//    public ResponseEntity<List<Account>> getAll() {
//        List<Account> accounts = accountsService.findAll();
//        if (accounts.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(accounts, HttpStatus.OK);
//        }
//    }
}
