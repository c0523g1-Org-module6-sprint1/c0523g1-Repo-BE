package com.dating.service.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.model.account.Account;
import com.dating.repository.relationship.IRecommendFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendFriendService implements IRecommendFriendService {
    @Autowired
    private IRecommendFriendRepository recommendFriendRepository;

    @Override
    public List<IRecommendFriendDto> findAllRecommendFriend(Integer accountID, Integer roleID) {
        if (roleID == 1) {
            return recommendFriendRepository.sortByLocation(accountID);
        } else if (roleID == 2) {
            return recommendFriendRepository.sortByJob(accountID);
        } else if (roleID == 3) {
            return recommendFriendRepository.sortByHobby(accountID);
        } else {
            return recommendFriendRepository.findAllRecommendFriend(accountID);
        }
    }

}
