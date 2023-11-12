package com.dating.controller.HauNH;

import com.dating.model.HauNH.AccountTypes;
import com.dating.service.HauNH.IAccountTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/accountTypes")
public class AccountTypesController {
    @Autowired
    private IAccountTypesService accountTypesService;
    @GetMapping("")
    public ResponseEntity<List<AccountTypes>> findAll(){
        List<AccountTypes> accountTypesList = accountTypesService.findAll();
        if (accountTypesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(accountTypesList,HttpStatus.OK);
        }
    }
}
