package com.dating.service.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.repository.relationship.IRecommendFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecommendFriendService implements IRecommendFriendService{
    @Autowired
    private IRecommendFriendRepository recommendFriendRepository;
    @Override
    public List<IRecommendFriendDto> findAllRecommendFriend(int accountID) {
        return recommendFriendRepository.findAllRecommendFriend(accountID);
    }

    @Override
    public List<IRecommendFriendDto> sortByJob(int accountID) {
        return recommendFriendRepository.sortByJob(accountID);
    }

    @Override
    public List<IRecommendFriendDto> sortByLocation(int accountID) {
        return recommendFriendRepository.sortByLocation(accountID);
    }

    @Override
    public List<IRecommendFriendDto> sortByHobby(int accountID) {
        return recommendFriendRepository.sortByHobby(accountID);
    }
}
