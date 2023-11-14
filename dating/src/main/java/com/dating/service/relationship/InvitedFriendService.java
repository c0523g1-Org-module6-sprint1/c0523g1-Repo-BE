package com.dating.service.relationship;

import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;
import com.dating.repository.relationship.IInvitedFriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InvitedFriendService implements IInvitedFriendService {
    @Autowired
    private IInvitedFriendRepository repository;


    @Override
    public List<IInvitedFriendDto> findAllInvitedFriend() {
        return repository.findAllInvitedFriend();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Relationships findById(int id) {
        return repository.findById(id).get();
    }
}
