package com.dating.controller.relationship;

import com.dating.dto.IFriendDto;
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
        @RequestParam(value = "name",defaultValue = "") String name
    ){
        List<IFriendDto> friendDtoList = null;
        friendDtoList = friendService.findAllFriendByName(name);
        return new ResponseEntity<>(friendDtoList, HttpStatus.OK);
    }
}
