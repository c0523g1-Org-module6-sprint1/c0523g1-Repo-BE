package com.dating.controller.update_account;

import com.dating.dto.update_account.AccountDto;
import com.dating.dto.update_account.PackageDetailDto;
import com.dating.model.update_account.PackageDetail;
import com.dating.service.update_account.IPackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/packageDetail")
public class PackageDetailController {
    @Autowired
    private IPackageDetailService packageDetailService;

    @GetMapping("")
    public ResponseEntity<List<PackageDetail>> findAll() {
        List<PackageDetail> packageDetailList = packageDetailService.findAll();
//        List<PackageDetail> packageDetailList = new ArrayList<>();
        if (packageDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(packageDetailList, HttpStatus.OK);
        }
    }

    //    @PatchMapping("/setAccountTypes/{accountId}/{accountTypesId}")
//    public ResponseEntity<String> setAccountTypes(@PathVariable Integer accountId, @PathVariable Integer accountTypesId) {
//        if (accountId == null || accountTypesId == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        packageDetailService.setAccountTypes(accountId, accountTypesId);
//        return ResponseEntity.ok("Sửa thành công");
//    }
    @PatchMapping("")
    public ResponseEntity<String> setAccountTypes(@RequestBody PackageDetailDto packageDetail) {
//        if (packageDetail.getAccount().getId() == null || packageDetail.getAccountTypes().getId() == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
        packageDetailService.setAccountTypes(packageDetail.getAccount(), packageDetail.getAccountTypes());
        return ResponseEntity.ok("Sửa thành công");
    }
    @PatchMapping("/setMoneyAccount")
    public ResponseEntity<String> setMoneyAccount(@RequestBody AccountDto accountDto) {
        packageDetailService.setMoneyAccount(accountDto.getIdAccount(), accountDto.getNewMoney());
        return ResponseEntity.ok("Sửa thành công");
    }
}
