package com.dating.controller.HauNH;

import com.dating.model.HauNH.PackageDetail;
import com.dating.service.HauNH.IAccountTypesService;
import com.dating.service.HauNH.IPackageDetailService;
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
@RequestMapping("/api/packageDetail")
public class PackageDetailController {
    @Autowired
    private IPackageDetailService packageDetailService;
    @GetMapping("")
    public ResponseEntity<List<PackageDetail>> getAll(){
        List<PackageDetail> packageDetailList = packageDetailService.findAll();
        if(packageDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(packageDetailList,HttpStatus.OK);
        }
    }
}
