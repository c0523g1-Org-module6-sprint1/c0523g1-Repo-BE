package com.dating.controller.update_account;

import com.dating.model.update_account.PackageTypes;
import com.dating.service.update_account.IPackageTypesService;
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
@RequestMapping("/api/packageTypes")
public class PackageTypesController {
    @Autowired
    private IPackageTypesService packageTypesService;
    @GetMapping("")
    public ResponseEntity<List<PackageTypes>> getAll(){
        List<PackageTypes> packageTypesList = packageTypesService.findAll();
        if(packageTypesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(packageTypesList,HttpStatus.OK);
        }
    }
}
