package com.dating.service.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;

import java.util.List;

public interface IInvitedFriendService {
    List<IInvitedFriendDto> findAllInvitedFriend();

    void delete(int id);

    Relationships findById(int id);
}
