package com.dating.service.relationship;

import com.dating.model.relationship.Relationships;

import java.util.List;

public interface IRecommendFriendService {
    List<Relationships> findAll();

}
