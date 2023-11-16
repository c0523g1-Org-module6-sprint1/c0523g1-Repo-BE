package com.dating.controller.account;

import com.dating.dto.account.AccountDto;
import com.dating.model.account.Account;
import com.dating.model.warning_detail.WarningDetails;
import com.dating.service.account.IAccountService;
import com.dating.service.warning_detail.IWarningDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IWarningDetailService iWarningDetailService;

    @GetMapping("/accounts")
    public ResponseEntity<Page<Account>> showAccountList(
            @RequestParam(value = "_page", defaultValue = "1") int page,
            @RequestParam(value = "username_like", defaultValue = "") String username
    ) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Account> accountList = iAccountService.findAll(pageable, username);
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

//    @PostMapping("/warning")
//    public ResponseEntity<?> handleWarning(@RequestParam Integer id) {
//        WarningDetails warningDetails = new WarningDetails();
//       Account account = iAccountService.findById(id);
//       if (account != null){
//           warningDetails.setAccount(account);
//           warningDetails.incrementFaultAmount();
//       }
//      switch (warningDetails.getFaultAmount()){
//          case 1:
//          case 2:
//          case 4:
//          case 5:
//          case 7:
//          case 8:
//          case 9:
//              return ResponseEntity.ok("Bạn bị cảnh cáo 1 lần");
//          case 3:
//              iWarningDetailService.lockAccount(warningDetails);
//              return  ResponseEntity.ok("Bạn bị khoá 7 ngày");
//          case 6:
//              iWarningDetailService.lockAccount(warningDetails);
//              return ResponseEntity.ok("Bạn bị khoa 30 ngày");
//          case 10:
//              iWarningDetailService.lockAccount(warningDetails);
//              return ResponseEntity.ok("Babnj bị khoá vĩnh viễn");
//          default:
//              break;
//      }
//    return null;
//    }

    @PatchMapping("/personal-page/edit/{id}")
    public ResponseEntity<?> editAccountByID(@PathVariable int id, @RequestBody AccountDto accountDto) {
        Account account = iAccountService.getAccountByID(id);

        if (account == null || accountDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account accountMain = new Account();
        BeanUtils.copyProperties(accountDto, accountMain);
        iAccountService.updateAccount(accountMain);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
