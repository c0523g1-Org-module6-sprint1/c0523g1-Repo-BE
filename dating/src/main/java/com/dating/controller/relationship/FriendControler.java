package com.dating.controller.relationship;


import com.dating.dto.relationship.FriendBlockDto;
import com.dating.dto.relationship.IFriendDto;
import com.dating.repository.account.IAccountRepository;
import com.dating.service.account.IAccountService;
import com.dating.service.relationship.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/member/friend")
public class FriendControler {
    @Autowired
    private IFriendService friendService;
    @Autowired
    private IAccountService accountService;

    /**
     * Method find All
     * Author ThienPT
     * Create 13-11-2023
     *
     * @param name : Select type to search
     * @return list friend management
     */
    @GetMapping("")
    public ResponseEntity<?> findAll(
             @RequestParam(value = "idLogin",required = false) Integer idLogin,
            @RequestParam(value = "name", required = false) String name
    ){
        if (name == null || idLogin == null || idLogin.equals("")){
            return new ResponseEntity<>("Giá trị  truyền vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        List<IFriendDto> friendDtoList = new ArrayList<>();
        friendDtoList = friendService.findAllFriendByName(idLogin,name);
        if (friendDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendDtoList, HttpStatus.OK);
    }

    @DeleteMapping ("/block")
    public ResponseEntity<?> blockFriend(
            @RequestParam(value = "idLogin", required = false) Integer idLogin,
            @RequestParam(value = "idFriend", required = false) Integer idFriend
    ) {
        if (idLogin == null || idFriend == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (accountService.findAccountById(idLogin) == null || accountService.findAccountById(idFriend) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        friendService.blockFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/unfriend")
    public ResponseEntity<?> unFriend(
            @RequestParam(value = "idLogin", required = false) Integer idLogin,
            @RequestParam(value = "idFriend", required = false) Integer idFriend
    ){
        if (idLogin == null || idFriend == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (accountService.findAccountById(idLogin) == null || accountService.findAccountById(idFriend) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        friendService.unFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}