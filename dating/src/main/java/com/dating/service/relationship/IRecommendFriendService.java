package com.dating.service.relationship;
import com.dating.dto.relationship.IRecommendFriendDto;
import java.util.List;

public interface IRecommendFriendService {
    List<IRecommendFriendDto> findAllRecommendFriend(Integer accountID, Integer roleID,String genderName, String locationName);

}
