package com.dating.HauNH_controller.account;

import com.dating.service.account.IChangePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/changePassword")
public class ChangePassword {
    @Autowired
    private IChangePasswordService iChangePasswordService;
    @GetMapping("")
    public ResponseEntity<String> updatePassword(@RequestParam String password){
        iChangePasswordService.update(password);
        return ResponseEntity.ok("dổi mật khẩu  thành công!");
    }
}
