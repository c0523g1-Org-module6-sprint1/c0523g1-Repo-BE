package com.dating.controller.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;
import com.dating.service.relationship.IInvitedFriendService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("")
    public ResponseEntity<List<IInvitedFriendDto>> findAll() {
        List<IInvitedFriendDto> invitedList = iInvitedFriendService.findAllInvitedFriend();
        if (invitedList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invitedList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Relationships> findById(@PathVariable int id) {
        Relationships invitedList = iInvitedFriendService.findById(id);
        return new ResponseEntity<>(invitedList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvited(@PathVariable int id) {
        iInvitedFriendService.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }
}


