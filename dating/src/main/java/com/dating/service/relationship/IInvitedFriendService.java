package com.dating.service.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.account.Account;
import com.dating.model.relationship.Relationships;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInvitedFriendService {
    List<IInvitedFriendDto> findAllInvitedFriend(Integer accountID);

    void delete(int id);
    void accept( Integer invitedID);


}
