package com.dating.controller.update_account;

import com.dating.model.update_account.AccountTypes;
import com.dating.service.update_account.IAccountTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public/accountTypes")
public class AccountTypesController {
    @Autowired
    private IAccountTypesService accountTypesService;
    @GetMapping("")
    public ResponseEntity<List<AccountTypes>> findAll(){
        List<AccountTypes> accountTypesList = accountTypesService.findAll();
//        List<AccountTypes> accountTypesList = new ArrayList<>();
        if (accountTypesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accountTypesList,HttpStatus.OK);
        }
    }
}
