package com.dating.controller.relationship;

import com.dating.dto.friend.FriendBlockDto;
import com.dating.dto.friend.IFriendDto;
import com.dating.service.relationship.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/member/relationship/friend")
public class FriendControler {
    @Autowired
    private IFriendService friendService;

    /**
     * Method find All
     * Author ThienPT
     * Create 13-11-2023
     *
     * @param name : Select type to search
     * @return list friend management
     */
    @GetMapping("")
    public ResponseEntity<List<IFriendDto>> findAll(
            @RequestParam(value = "name", defaultValue = "") String name
    ) {
        List<IFriendDto> friendDtoList = null;
        friendDtoList = friendService.findAllFriendByName(name);
        return new ResponseEntity<>(friendDtoList, HttpStatus.OK);
    }

    @PostMapping("/block/{idLogin}")
    public ResponseEntity<?> blockFriend(
            @PathVariable Integer idLogin,
            @RequestBody FriendBlockDto request
    ) {
        if (idLogin == null || request.getIdFriend() == null) {
            return new ResponseEntity<>("Giá trị id không thể null!", HttpStatus.BAD_REQUEST);
        }
        Integer idFriend = request.getIdFriend();
        friendService.blockFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/unfriend/{idLogin}")
    public ResponseEntity<?> unFriend(
            @PathVariable Integer idLogin,
            @RequestBody FriendBlockDto request
    ){
        if (idLogin == null || request.getIdFriend() == null) {
            return new ResponseEntity<>("Giá trị id không thể null!", HttpStatus.BAD_REQUEST);
        }
        Integer idFriend = request.getIdFriend();
        friendService.unFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
