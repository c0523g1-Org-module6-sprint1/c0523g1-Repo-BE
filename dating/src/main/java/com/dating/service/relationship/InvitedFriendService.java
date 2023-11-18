package com.dating.service.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.account.Account;
import com.dating.model.relationship.Relationships;
import com.dating.repository.relationship.IInvitedFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvitedFriendService implements IInvitedFriendService {
    @Autowired
    private IInvitedFriendRepository repository;


    @Override
    public List<IInvitedFriendDto> findAllInvitedFriend(Integer accountID) {
        return repository.findAllInvitedFriend(accountID);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void accept(Integer invitedID) {
        repository.acceptInvited(invitedID);
    }
}
