package com.dating.controller.account;


import com.dating.dto.account.AccountDTOs;
import com.dating.model.account.Account;
import com.dating.model.warning_detail.WarningDetails;
import com.dating.service.account.IAccountService;
import com.dating.service.warning_detail.IWarningDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IWarningDetailService iWarningDetailService;

    /**
     * TriVN
     * display list accounts
     * search
     * page
     * @param pageable
     * @param username
     * @return
     */
    @GetMapping("/accounts")
    public ResponseEntity<?> showAccountList(
            @PageableDefault(size = 5) Pageable pageable,
            @RequestParam( defaultValue = "",required = false) String username
    ) {
        Page<AccountDTOs> accountList = iAccountService.findAll(pageable, username);
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }



    @PatchMapping("/personal-page/edit/{id}")
    public ResponseEntity<?> editAccountByID(@PathVariable int id, @RequestBody AccountDTOs accountDto) {
        Account account = iAccountService.findAccountById(id);

        if (account == null || accountDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account accountMain = new Account();
        BeanUtils.copyProperties(accountDto, accountMain);
        iAccountService.updateAccount(accountMain);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * TriVN
     * Lock account
     * @param id
     * @return
     */
    @PatchMapping ("/accounts/{id}")
    public ResponseEntity<?> handleWarning(@PathVariable Integer id) {
        WarningDetails warningDetails = new WarningDetails();
       Account account = iAccountService.findAccountById(id);
       if (account == null){
           warningDetails.setAccount(account);
           warningDetails.incrementFaultAmount();
       }
      switch (warningDetails.getFaultAmount()){
          case 1:
          case 2:
          case 4:
          case 5:
          case 7:
          case 8:
          case 9:
              return ResponseEntity.ok("Bạn bị cảnh cáo 1 lần");
          case 3:
              iWarningDetailService.lockAccount(warningDetails);
              return  ResponseEntity.ok("Bạn bị khoá 7 ngày");
          case 6:
              iWarningDetailService.lockAccount(warningDetails);
              return ResponseEntity.ok("Bạn bị khoa 30 ngày");
          case 10:
              iWarningDetailService.lockAccount(warningDetails);
              return ResponseEntity.ok("Bạn bị khoá vĩnh viễn");
          default:
              break;
      }
    return null;
    }

//    @PatchMapping("/accounts/{id}")
//    public ResponseEntity<?> lockAccount(@RequestParam Integer id){
//        Account account = iAccountService.findAccountById(id);
//        if (account == null){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//       iAccountService.deleteAccount(id);
//       return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PatchMapping("/personal-page/edit/{id}")
//    @ResponseBody
//    public ResponseEntity<Object> updateAccount(@Valid @ResponseBody AccountDto accountDto, BindingResult bindingResult){
//        new AccountDto
//    }
}
