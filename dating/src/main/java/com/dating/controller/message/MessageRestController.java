package com.dating.controller.message;

import com.dating.dto.MessageDto;
import com.dating.model.account.Account;
import com.dating.model.message.Messages;
import com.dating.service.message.IMessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/message/")
public class MessageRestController {
    @Autowired
    private IMessageService messageService;
    @GetMapping("friendMessage/{id}")
    public ResponseEntity<List<Messages>> getFriendMessage(Integer id){
        List<Messages> messagesList = messageService.getMessage(id);
        List<Account> friendList = messageService.getFriendList(id);

        List<Messages> friendMess = new ArrayList<>();
        List<Messages> unknowMess = new ArrayList<>();

        for (Messages messages : messagesList) {
            Account accountCheck;
            Account receiver = messages.getReceiverAccount();
            Account sender = messages.getSenderAccount();

            if (id == receiver.getId()) {
                accountCheck = sender;
            } else {
                accountCheck = receiver;
            }

            if (friendList.contains(accountCheck)) {
                friendMess.add(messages);
            } else {
                unknowMess.add(messages);
            }
        }
        if (friendMess.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(friendMess, HttpStatus.OK);
        }
    }
    @GetMapping("unknowMessage/{id}")
    public ResponseEntity<List<Messages>> getUnknowMessage(Integer id){
        List<Messages> messagesList = messageService.getMessage(id);
        List<Account> friendList = messageService.getFriendList(id);

        List<Messages> friendMess = new ArrayList<>();
        List<Messages> unknowMess = new ArrayList<>();

        for (Messages messages : messagesList) {
            Account accountCheck;
            Account receiver = messages.getReceiverAccount();
            Account sender = messages.getSenderAccount();

            if (id == receiver.getId()) {
                accountCheck = sender;
            } else {
                accountCheck = receiver;
            }

            if (friendList.contains(accountCheck)) {
                friendMess.add(messages);
            } else {
                unknowMess.add(messages);
            }
        }
        if (friendMess.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(unknowMess, HttpStatus.OK);
        }
    }
    @GetMapping("friendList")
    public ResponseEntity<List<Account>> getFriend(Integer id){
        List<Account> friendList = messageService.getFriendList(id);
        if (friendList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(friendList, HttpStatus.OK);
        }
    }
    @PostMapping("createMessage")
    public ResponseEntity<?> createMessage(@RequestBody MessageDto messageDto){
        if (messageDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Messages messages = new Messages();
            BeanUtils.copyProperties(messageDto, messages);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}
