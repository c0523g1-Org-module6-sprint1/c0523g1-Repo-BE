package com.dating.controller.message;
import com.dating.model.account.Account;
import com.dating.model.message.Messages;
import com.dating.service.message.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/public/message/")
public class MessageRestController {
    @Autowired
    private IMessageService messageService;

    private Integer accountIdfake = 1;

    @GetMapping("account")
    public ResponseEntity<Account> getOwnAccount(){
        Account account = messageService.findAccountById(accountIdfake);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }
    @GetMapping("chatlist")
    public ResponseEntity<List<Account>> getFriendList(
            @RequestParam(required = false, defaultValue = "") String name){
        Account account = messageService.findAccountById(accountIdfake);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            List<Account> friendList = messageService.getFriendList(accountIdfake, name);
            List<Account> result = new ArrayList<>();
            for (Account friend : friendList) {
                if (friend.getUserName().contains(name)){
                    result.add(friend);
                }
            }
            if (result.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
        }
    }
    @GetMapping("unknowlist")
    public ResponseEntity<List<Account>> getUnknowMess(
            @RequestParam(required = false, defaultValue = "") String name){
        Account account = messageService.findAccountById(accountIdfake);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            List<Account> unknowMess = messageService.getUnknowList(accountIdfake, name);
            if (unknowMess.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(unknowMess, HttpStatus.OK);
            }
        }
    }
    @GetMapping("Chatbox/{id}")
    public ResponseEntity<?> checkContact(@PathVariable(required = false) Integer id){
        Account account = messageService.findAccountById(accountIdfake);
        if (id == null || account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Messages messages = messageService.getMessageByAccountId(accountIdfake, id);
            if (messages == null) {
                Messages newMess = messageService.createMessage(accountIdfake, id);
                return new ResponseEntity<>(newMess, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(messages, HttpStatus.OK);
            }
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChatbox(@PathVariable(required = false) Integer id){
        if (id != null){
            messageService.deleteMessage(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/setbusy")
    public ResponseEntity<?> setBusyMode(@RequestParam(name = "busyMode", defaultValue = "false") Boolean busyMode){
        Account account = messageService.findAccountById(accountIdfake);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            messageService.setBusy(busyMode, accountIdfake);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
