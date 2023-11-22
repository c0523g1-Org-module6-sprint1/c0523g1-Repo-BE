package com.dating.controller.account;

import com.dating.dto.account.AccountDTOs;
import com.dating.dto.account.AccountDto;
import com.dating.model.account.Account;
import com.dating.model.update_account.AccountTypes;
import com.dating.model.warning_detail.WarningDetails;
import com.dating.service.account.IAccountService;
import com.dating.service.account.ITypeAccountService;
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
@RequestMapping("/api/public")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private IWarningDetailService iWarningDetailService;
    @Autowired
    private ITypeAccountService iTypeAccountService;

    /**
     * TriVN
     * display list accounts
     * search
     * page
     *
     * @param page
     * @param username
     * @return
     */
    @GetMapping("/accounts")
    public ResponseEntity<?> showAccountList(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "limit", defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "", required = false) String username,
            @RequestParam(defaultValue = "", required = false) String typeAccount
    ) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<AccountDTOs> accountList = iAccountService.findAll(pageable, username, typeAccount);
        if (accountList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    /**
     * TriVN
     * display typeAccounts
     *
     * @return
     */
    @GetMapping("/typeAccounts")
    public ResponseEntity<List<AccountTypes>> showTypeAccount() {
        List<AccountTypes> accountTypesList = iTypeAccountService.findTypeAccount();
        if (accountTypesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(accountTypesList, HttpStatus.OK);
    }

    @PutMapping("/warning")
    public ResponseEntity<WarningDetails> warningDetails(@RequestBody List<Integer> warningId) {
        if (warningId == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Integer i : warningId) {
            iTypeAccountService.warning(i);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/api/personal-page/edit/{id}")
    public ResponseEntity<?> editAccountByID(@PathVariable int id, @RequestBody AccountDto accountDto) {

        Account account = iAccountService.findAccountById(id);

        if (account == null || accountDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BeanUtils.copyProperties(accountDto, account);
        iAccountService.setEditAccount(accountDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * TriVN
     * Lock account
     * @param id
     * @return
     */
//    @PatchMapping("/accounts/{id}")
//    public ResponseEntity<?> handleWarning(@PathVariable Integer id) {
//        WarningDetails warningDetails = new WarningDetails();
//        Account account = iAccountService.findAccountById(id);
//        if (account == null) {
//            warningDetails.setAccount(account);
//            warningDetails.incrementFaultAmount();
//        }
//        switch (warningDetails.getFaultAmount()) {
//            case 1:
//            case 2:
//            case 4:
//            case 5:
//            case 7:
//            case 8:
//            case 9:
//                return ResponseEntity.ok("Bạn bị cảnh cáo 1 lần");
//            case 3:
//                iWarningDetailService.lockAccount(warningDetails);
//                return ResponseEntity.ok("Bạn bị khoá 7 ngày");
//            case 6:
//                iWarningDetailService.lockAccount(warningDetails);
//                return ResponseEntity.ok("Bạn bị khoa 30 ngày");
//            case 10:
//                iWarningDetailService.lockAccount(warningDetails);
//                return ResponseEntity.ok("Bạn bị khoá vĩnh viễn");
//            default:
//                break;
//        }
//        return null;
//    }

    /**
     * TriVN
     * lock account
     *
     * @param list
     * @return
     */
    @PatchMapping("/accounts/lock/")
    public ResponseEntity<?> lockAccount(@RequestBody List<Integer> list) {
        for (Integer integer : list) {
            Account account = iAccountService.findByIdUnlock(integer);
            if (account == null) {
                return new ResponseEntity<>("Không tìm thấy", HttpStatus.NOT_FOUND);
            } else {
                iAccountService.lockAccount(integer);
            }
        }
        return new ResponseEntity<>("Đã lock thành công", HttpStatus.OK);
    }

    /**
     * TriVn
     * unlock account
     *
     * @param id
     * @return
     */
    @PatchMapping("/accounts/unlock/{id}")
    public ResponseEntity<?> unlockAccount(@PathVariable("id") Integer id) {
        Account account = iAccountService.findByIdUnlock(id);
        if (account == null) {
            return new ResponseEntity<>("Không tìm thấy", HttpStatus.NOT_FOUND);
        } else {
            iAccountService.unlockAccount(id);
            return new ResponseEntity<>("Đã Mở Nick Thành Công", HttpStatus.OK);
        }
    }

    @GetMapping("/api/public/personal-page/edit/{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable("id") Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Account account = iAccountService.findAccountById(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
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