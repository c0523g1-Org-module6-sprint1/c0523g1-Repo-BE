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
@RequestMapping("api/public/relationship/friend")
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
    @GetMapping("/{idLogin}")
    public ResponseEntity<?> findAll(
            @PathVariable Integer idLogin,
            @RequestParam(value = "name", defaultValue = "") String name
    ){
        List<IFriendDto> friendDtoList = new ArrayList<>();
        friendDtoList = friendService.findAllFriendByName(idLogin,name);
        if (name == null || name.equals("") ){
            return new ResponseEntity<>("Giá trị name truyền vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (friendDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(friendDtoList, HttpStatus.OK);
    }

    @DeleteMapping ("/block/{idLogin}")
    public ResponseEntity<?> blockFriend(
            @PathVariable Integer idLogin,
            @RequestBody FriendBlockDto request
    ) {
        if (request == null){
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (idLogin == null || idLogin.equals("") || request.getIdFriend() == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (accountService.findAccountById(idLogin) == null || accountService.findAccountById(request.getIdFriend()) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Integer idFriend = request.getIdFriend();
        friendService.blockFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/unfriend/{idLogin}")
    public ResponseEntity<?> unFriend(
            @PathVariable Integer idLogin,
            @RequestBody FriendBlockDto request
    ){
        if (request == null){
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (idLogin == null || idLogin.equals("") || request.getIdFriend() == null) {
            return new ResponseEntity<>("Giá trị id nhận vào không thể null!", HttpStatus.BAD_REQUEST);
        }
        if (accountService.findAccountById(idLogin) == null || accountService.findAccountById(request.getIdFriend()) == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Integer idFriend = request.getIdFriend();
        friendService.unFriend(idLogin,idFriend);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}