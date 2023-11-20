package com.dating.controller.account;

import com.dating.dto.GiftRecordDto.PasswordDto;
import com.dating.model.account.Account;
import com.dating.service.account.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/public/changePassword")
public class ChangePassword {
    @Autowired
    private IChangePasswordService iChangePasswordService;
    @Autowired
    private PasswordEncoder passwordEncoder;


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

        String EncodedPassword = passwordEncoder.encode(passwordDto.getPassword());
        Account account = iChangePasswordService.findPassword(passwordDto.getUserName());
        System.out.println(account);

        if (passwordEncoder.matches(passwordDto.getPassword(), account.getPassword())) {
            // Mật khẩu hiện tại hợp lệ
            String newEncodedPassword = passwordEncoder.encode(passwordDto.getNewPassword());
            iChangePasswordService.update(account.getUserName(), newEncodedPassword);
            return ResponseEntity.ok("Đổi mật khẩu thành công!");
        } else {
            // Mật khẩu hiện tại không chính xác
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mật khẩu cũ không chính xác!");
        }
    }
}
