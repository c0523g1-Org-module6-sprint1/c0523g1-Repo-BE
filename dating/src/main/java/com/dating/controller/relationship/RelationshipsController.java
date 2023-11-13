package com.dating.controller.relationship;

import com.dating.model.relationship.Relationships;
import com.dating.service.relationship.ISendInvitedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin("*")
@RestController
@RequestMapping
public class RelationshipsController {

    @Autowired
    private ISendInvitedService sendInvitedService;

    @PostMapping("api/sent-invite/")
    public ResponseEntity<?> saveInviteFriend(@RequestBody Relationships relationships){
        if (relationships == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        relationships.setDateRequest(LocalDateTime.now());
        sendInvitedService.saveInvited(relationships);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
