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
@RequestMapping("api/member/relationship/recommend")
public class RecommendFriendController {
    @Autowired
    private IRecommendFriendService recommendFriendService;

    /**
     * Method find All
     * Author HungHLP
     * Create 13-11-2023
     *
     * @param name : Select type to search
     * @return list  recommend friend
     */
    @GetMapping("")
    public ResponseEntity<List<IRecommendFriendDto>> findAll(
            @RequestParam(value = "name",defaultValue = "") String name
    ){
        List<IRecommendFriendDto> recommendDtoList = null;
        recommendDtoList = recommendFriendService.findAllRecommendFriend(name);
        return new ResponseEntity<>(recommendDtoList, HttpStatus.OK);
    }
}