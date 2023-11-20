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

    /**
     * method getOwnAccount => get logged in Account
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer accountId
     * return new Object: Account
     */
    @GetMapping("account")
    public ResponseEntity<Account> getOwnAccount(@RequestParam Integer accountId){
        Account account = messageService.findAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }
    /**
     * method getFriendList
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer accountId, String searchName
     * return new Object: List<Account></Account>
     */
    @GetMapping("chatlist")
    public ResponseEntity<List<Account>> getFriendList(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam Integer accountId){
        Account account = messageService.findAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            List<Account> friendList = messageService.getFriendList(accountId, name);
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
    /**
     * method getUnknowlist => list of person sended message but not be friend
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer accountId, String searchName
     * return new Object: List<Account>
     */
    @GetMapping("unknowlist")
    public ResponseEntity<List<Account>> getUnknowMess(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam Integer accountId){
        Account account = messageService.findAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            List<Account> unknowMess = messageService.getUnknowList(accountId, name);
            if (unknowMess.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(unknowMess, HttpStatus.OK);
            }
        }
    }

    /**
     * method getChatbox
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer accountOwnId, Integer accountFriendId
     * return new Object: Message
     */
    @GetMapping("Chatbox")
    public ResponseEntity<?> checkContact(@RequestParam Integer id,
                                          @RequestParam Integer accountId){
        Account account = messageService.findAccountById(accountId);
        if (id == null || account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            Messages messages = messageService.getMessageByAccountId(accountId, id);
            if (messages == null) {
                Messages newMess = messageService.createMessage(accountId, id);
                return new ResponseEntity<>(newMess, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(messages, HttpStatus.OK);
            }
        }
    }

    /**
     * method deleteChatbox
     * Create ThangLQ
     * Date 13-11-2023
     * param Integer messageId
     * return new Object: void
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChatbox(@PathVariable(required = false) Integer id){
        if (id != null){
            messageService.deleteMessage(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * method setBusyMode
     * Create ThangLQ
     * Date 13-11-2023
     * param Boolean busyMode, Integer accountId
     * return new Object: void
     */
    @PostMapping("/setbusy")
    public ResponseEntity<?> setBusyMode(@RequestParam(name = "busyMode", defaultValue = "false") Boolean busyMode,
                                         @RequestParam Integer accountId){
        Account account = messageService.findAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            messageService.setBusy(busyMode, accountId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}

