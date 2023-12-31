package com.dating.controller.relationship;


import com.dating.dto.relationship.FriendBlockDto;
import com.dating.dto.relationship.IFriendDto;
import com.dating.repository.account.IAccountRepository;
import com.dating.service.account.IAccountService;
import com.dating.service.relationship.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/public/friend")
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
            @RequestParam(value = "name", required = false) String name,
             @RequestParam(value= "limit", required = false) Integer limit
    ){
        Pageable pageable = PageRequest.of(0,limit);
        if (name == null || idLogin == null || idLogin.equals("")){
            return new ResponseEntity<>("Giá trị  truyền vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        Page<IFriendDto> friendDtoList = friendService.findAllFriendByName(idLogin,name,pageable);
        if (friendDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendDtoList, HttpStatus.OK);
    }

    /**
     * Method block friend
     * Author ThienPT
     * Create 13-11-2023
     *
     * @param idLogin : IdLogin is login in web
     * @param idFriend : IdFriend is friend with account login in web
     * @return void
     */

    @PatchMapping ("/block")
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

    /**
     * Method unfriend
     * Author ThienPT
     * Create 13-11-2023
     *
     * @param idLogin : IdLogin is login in web
     * @param idFriend : IdFriend is friend with account login in web
     * @return void
     */
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


    /**
     * Method  Unblock friend
     * Author ThienPT
     * Create 13-11-2023
     *
     * @param idLogin : IdLogin is login in web
     * @param idFriend : IdFriend is friend with account login in web
     * @return void
     */
    @PatchMapping ("/unblock")
    public ResponseEntity<?> unblockFriend(
            @RequestParam(value = "idLogin", required = false) Integer idLogin,
            @RequestParam(value = "idFriend", required = false) Integer idFriend
    ) {
        if (idLogin == null || idFriend == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        friendService.unblockFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}