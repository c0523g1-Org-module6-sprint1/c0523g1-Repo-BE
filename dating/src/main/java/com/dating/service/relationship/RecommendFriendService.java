package com.dating.service.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.repository.relationship.IRecommendFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendFriendService implements IRecommendFriendService {
    @Autowired
    private IRecommendFriendRepository recommendFriendRepository;

    @Override
    public List<IRecommendFriendDto> findAllRecommendFriend(Integer accountID, Integer roleID, String genderName, String locationName) {

        if ("".equals(genderName)) {
            genderName = "%";
        }
        if ("".equals(locationName)) {
            locationName = "%";
        }
        if (roleID == 1) {
            return recommendFriendRepository.sortByJob(accountID, genderName, locationName);
        } else if (roleID == 2) {
            return recommendFriendRepository.sortByHobby(accountID, genderName, locationName);
        } else if (roleID == 3) {
            return recommendFriendRepository.findAllRecommendFriend(accountID, genderName, locationName);
        } else {
            return recommendFriendRepository.findAllRecommendFriend(accountID, genderName, locationName);
        }
    }

}
