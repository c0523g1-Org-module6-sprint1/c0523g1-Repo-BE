package com.dating.controller.update_account;

import com.dating.dto.update_account.PackageDto;
import com.dating.model.update_account.PackageTypes;
import com.dating.service.update_account.IPackageTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/packageTypes")
public class PackageTypesController {
    @Autowired
    private IPackageTypesService packageTypesService;
    @GetMapping("")
    public ResponseEntity<List<PackageTypes>> findAll(){
        List<PackageTypes> packageTypesList = packageTypesService.findAll();
//        List<PackageTypes> packageTypesList = new ArrayList<>();
        if(packageTypesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(packageTypesList,HttpStatus.OK);
        }
    }
    @GetMapping("/packageAccount")
    public ResponseEntity<List<PackageDto>> findAllPackageAccount(){
        List<PackageDto> packageDtos = packageTypesService.findAllPackageAccount();
        if(packageDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(packageDtos,HttpStatus.OK);
        }
    }
}
