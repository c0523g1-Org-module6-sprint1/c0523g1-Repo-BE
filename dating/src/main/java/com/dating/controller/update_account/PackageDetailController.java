package com.dating.controller.update_account;


import com.dating.dto.update_account.AccountDto;
import com.dating.dto.update_account.PackageDetailDto;
import com.dating.model.update_account.PackageDetail;
import com.dating.service.update_account.IPackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PatchMapping("")
    public ResponseEntity<String> setAccountTypes(@RequestBody PackageDetailDto packageDetail) {
        packageDetailService.setAccountTypes(packageDetail.getAccount(), packageDetail.getAccountTypes());
        return ResponseEntity.ok("Sửa thành công");
    }

    @PatchMapping("/setMoneyAccount")
    public ResponseEntity<String> setMoneyAccount(@RequestBody AccountDto accountDto) {
        packageDetailService.setMoneyAccount(accountDto.getIdAccount(), accountDto.getNewMoney());
        return ResponseEntity.ok("Sửa thành công");
    }

    @PatchMapping("/registrationDate/{date}/{regisDate}/{idAccount}")
    public ResponseEntity<String> registrationDate(
            @PathVariable(value = "date", required = false) String date,
            @PathVariable(value = "regisDate", required = false) String regisDate,
            @PathVariable(value = "idAccount", required = false) int idAccount) {
        LocalDate newDate1 = null;
        LocalDate newDate2 = null;
        if (date != null && regisDate != null) {
            newDate1 = LocalDate.parse(date);
            newDate2 = LocalDate.parse(regisDate);
            packageDetailService.registrationDate(newDate1, newDate2, idAccount);
            return ResponseEntity.ok("Sửa thành công");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
