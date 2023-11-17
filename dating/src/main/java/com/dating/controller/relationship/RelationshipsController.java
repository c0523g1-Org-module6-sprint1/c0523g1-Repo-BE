package com.dating.controller.relationship;

import com.dating.dto.relationships.IRelationshipsDTO;
import com.dating.dto.relationships.RelationshipsDTO;
import com.dating.model.account.Account;
import com.dating.model.relationship.RelationshipStatus;
import com.dating.model.relationship.Relationships;
import com.dating.service.account.IAccountService;
import com.dating.service.relationship.IRelationshipStatusService;
import com.dating.service.relationship.ISendInvitedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping
public class RelationshipsController {

    @Autowired
    private ISendInvitedService sendInvitedService;
    @Autowired
    private IRelationshipStatusService relationshipStatusService;

    @Autowired
    private IAccountService accountService;

    /**
     * Method saveInviteFriend
     * Create by LongTND
     * Date 14/11/2023
     * @param relationshipsDTO
     * @return status
     */
    @PostMapping("/api/public/sent-invite/")
    public ResponseEntity<?> saveInviteFriend(@RequestBody RelationshipsDTO relationshipsDTO){

        if (relationshipsDTO == null || relationshipsDTO.getSendAccount() == null || relationshipsDTO.getSendAccount() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Relationships relationships = new Relationships();
        BeanUtils.copyProperties(relationshipsDTO,relationships);
        Account sendAccount = new Account();
        sendAccount.setId(relationshipsDTO.getSendAccount());
        Account receiverAccount = new Account();
        receiverAccount.setId(relationshipsDTO.getReceiverAccount());
        relationships.setSenderAccount(sendAccount);
        relationships.setReceiverAccount(receiverAccount);
        RelationshipStatus relationshipStatus = relationshipStatusService.findStatusByID(1);
        relationships.setRelationshipStatus(relationshipStatus);
        relationships.setDateRequest(LocalDateTime.now());
        sendInvitedService.saveInvited(relationships);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Method findAccountByID
     * Create by LongTND
     * Date 14/11/2023
     * @Param id
     * @Return Account
     */
    @GetMapping("/api/public/personal-page/{id}")
    public ResponseEntity<Account> findAccountByID(@PathVariable Integer id){
        Account account = accountService.findByID(id);
        if (account == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    /**
     * Method findAccountByUserName
     * Create by LongTND
     * Date 15/11/2023
     * @Param userName
     * @Return Account
     */
    @GetMapping("/api/public/{name}")
    public ResponseEntity<Account> findAccountByUserName(@PathVariable String name){
        Account account = accountService.findAccountByUserName(name);
        if (account == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(account,HttpStatus.OK);
    }

    /**
     * Method getStatusRelationships
     * Create by LongTND
     * Date 16/11/2023
     * @Param null
     * @Return status ID
     */

    @GetMapping("/api/public/status/{idSent}/{idReceiver}")
    public ResponseEntity<Relationships> getRelationshipStatus(@PathVariable("idSent") int idSent, @PathVariable("idReceiver") int idReceiver){
        Relationships relationships =sendInvitedService.getRelationshipsStatus(idSent,idReceiver);
        if (relationships == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(relationships,HttpStatus.OK);

    }

}
