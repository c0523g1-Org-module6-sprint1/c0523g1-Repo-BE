package com.dating.controller.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;
import com.dating.service.account.IAccountService;
import com.dating.service.relationship.IInvitedFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/public/invited")
public class InvitedFriendController {
    @Autowired
    private IInvitedFriendService iInvitedFriendService;
    @Autowired
    private IAccountService accountService;

    @GetMapping("")
    public ResponseEntity<List<IInvitedFriendDto>> findAll(
            @RequestParam(value = "accountID", required = false) Integer accountID
    ) {
        List<IInvitedFriendDto> invitedFriend = iInvitedFriendService.findAllInvitedFriend(accountID);
        if (invitedFriend.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invitedFriend, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvited(@PathVariable int id) {
        iInvitedFriendService.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }


    @DeleteMapping ("/accept")
    public ResponseEntity<?> acceptInvited(
            @RequestParam(value = "accountID", required = false) Integer accountID,
            @RequestParam(value = "idFriend", required = false) Integer idFriend
    ) {
        if (accountID == null || idFriend == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.
                    BAD_REQUEST
            );
        }
        if (accountService.findAccountById(accountID) == null || accountService.findAccountById(idFriend) == null){
            return new ResponseEntity<>(HttpStatus.
                    BAD_REQUEST);
        }
        iInvitedFriendService.accept(accountID,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


