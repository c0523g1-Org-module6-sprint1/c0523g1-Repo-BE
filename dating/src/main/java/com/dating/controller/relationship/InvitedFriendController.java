package com.dating.controller.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.dto.relationships.RelationshipsDTO;
import com.dating.model.account.Account;
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findAll(@PathVariable(value = "id", required = false) Integer accountID) {
        List<IInvitedFriendDto> invitedList = iInvitedFriendService.findAllInvitedFriend(accountID);
        if (invitedList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invitedList, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvited(@PathVariable int id) {
        iInvitedFriendService.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }


    @PutMapping("/accept/{invitedID}")
    public ResponseEntity<?> acceptInvited(
            @PathVariable(value = "invitedID", required = false) Integer invitedID
    ) {
        if(accountService.findAccountById(invitedID )==null){
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (invitedID == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        } else {
            iInvitedFriendService.accept(invitedID);
            return new ResponseEntity<>(HttpStatus.OK);

        }
    }
}

