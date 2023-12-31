package com.dating.controller.relationship;
import com.dating.dto.relationship.IInvitedFriendDto;
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

    /**
     * Method find All
     * Author HungHLP
     * Create 13-11-2023
     *Param Integer id, boolean sortDesc
     * @return list  invited friend DESC, if false return invited friend ASC
     */

    @GetMapping("/{id}/{sortByDesc}")
    public ResponseEntity<?> findAll(@PathVariable(value = "id", required = false) Integer accountID,
                                     @PathVariable(value = "sortByDesc") boolean sortByDesc) {
        List<IInvitedFriendDto> invitedList = iInvitedFriendService.findAllInvitedFriend(accountID, sortByDesc);
        if (invitedList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invitedList, HttpStatus.OK);
        }
    }

    /**
     * Method deleted invited
     * Author HungHLP
     * Create 13-11-2023
     *Param invited id
     * @return list  invited friend
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvited(@PathVariable int id) {
        iInvitedFriendService.delete(id);
        return ResponseEntity.ok("Xóa thành công!");
    }

    /**
     * Method accept invited
     * Author HungHLP
     * Create 13-11-2023
     *Param Invited ID
     * @return list  invited friend
     */


    @PutMapping("/accept/{invitedID}")
    public ResponseEntity<?> acceptInvited(
            @PathVariable(value = "invitedID", required = false) Integer invitedID
    ) {
//        if (accountService.findAccountById(invitedID) == null) {
//            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
//        }
//        if (invitedID == null) {
//            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
//        } else {
        iInvitedFriendService.accept(invitedID);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}


