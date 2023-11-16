package com.dating.controller.account;

import com.dating.dto.GiftRecordDto.PasswordDto;
import com.dating.model.account.Account;
import com.dating.service.account.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/changePassword")
public class ChangePassword {
    @Autowired
    private IChangePasswordService iChangePasswordService;


    /**
     * method updatePassword
     * Create QuyNP
     * Date 13-11-2023
     */

    @PatchMapping("")
    public ResponseEntity<String> updatePassword(@RequestBody @Valid PasswordDto passwordDto,
                                                 BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mật khẩu không hợp lệ!");
        }


        Account account = iChangePasswordService.findPassword(passwordDto.getUserName());

        if (account != null && passwordDto.getPassword().equals(account.getPassword())) {
            iChangePasswordService.update(account.getUserName(), passwordDto.getNewPassword());
            return ResponseEntity.ok("Đổi mật khẩu thành công!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu cũ không chính xác!");
        }
    }
}
