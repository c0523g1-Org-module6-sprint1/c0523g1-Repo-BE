package com.dating.controller.relationship;
import com.dating.dto.relationship.IRecommendFriendDto;
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

    /**
     * Method find All
     * Author HungHLP
     * Create 13-11-2023
     * @return list  recommend friend
     */
    @GetMapping("")
    public ResponseEntity<List<IRecommendFriendDto>> findAll(
            @RequestParam(value = "accountID",required = false)
            Integer accountID){
        List<IRecommendFriendDto> recommendDtoList = null;
        recommendDtoList = recommendFriendService.findAllRecommendFriend(accountID);
        return new ResponseEntity<>(recommendDtoList, HttpStatus.OK);
    }
}