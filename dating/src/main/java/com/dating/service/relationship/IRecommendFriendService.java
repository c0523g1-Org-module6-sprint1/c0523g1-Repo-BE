package com.dating.service.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.model.account.Account;
import com.dating.model.relationship.Relationships;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecommendFriendService {
    List<IRecommendFriendDto> findAllRecommendFriend(Integer accountID, Integer roleID);

}
