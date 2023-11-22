package com.dating.controller.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.model.account.Account;
import com.dating.model.location.Location;
import com.dating.service.account.IAccountService;
import com.dating.service.location.ILocationService;
import com.dating.service.relationship.IRecommendFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/public/recommend")
public class RecommendFriendController {
    @Autowired
    private IRecommendFriendService recommendFriendService;
    @Autowired
    private ILocationService locationService;

//    @GetMapping("/{id}/{roleID}/{genderName}")
//    public ResponseEntity<?> findAll(@PathVariable(value = "id", required = false) Integer accountID,
//                                     @PathVariable(value = "roleID", required = false) Integer roleID,
//                                     @PathVariable(value = "genderName", required = false) String genderName) {
//        System.out.println(accountID);
//        System.out.println(roleID);
//        System.out.println(genderName);
//        List<IRecommendFriendDto> invitedList;
//        if (genderName==null){
//            invitedList = recommendFriendService.findAllRecommendFriendNotGender(accountID, roleID);
//        } else {
//            invitedList = recommendFriendService.findAllRecommendFriend(accountID, roleID, genderName);
//        }
//
//        if (invitedList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(invitedList, HttpStatus.OK);
//        }
//    }


    /**
     * Method find All
     * Author HungHLP
     * Create 13-11-2023
     *Param id, roleID, genderName, locationName
     * @return list  recommend friend
     */
    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(value = "id", required = false) Integer accountID,
                                     @RequestParam(value = "roleID", required = false) Integer roleID,
                                     @RequestParam(value = "genderName", required = false) String genderName,
                                     @RequestParam(value = "locationName", required = false) String locationName
    ) {
        List<IRecommendFriendDto> invitedList = recommendFriendService.findAllRecommendFriend(accountID, roleID, genderName, locationName);
        if (invitedList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(invitedList, HttpStatus.OK);
        }
    }


    /**
     * Method find All Location
     * Author HungHLP
     * Create 13-11-2023
     * @return list select Location
     */

    @GetMapping("/locationHLP")
    public ResponseEntity<?> findAllLocation() {
        List<Location> locations = locationService.getAll();
        if (locations.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(locations, HttpStatus.OK);
        }
    }
}