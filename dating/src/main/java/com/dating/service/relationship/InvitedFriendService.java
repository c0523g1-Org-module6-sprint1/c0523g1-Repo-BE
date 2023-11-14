package com.dating.service.relationship;

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
    public List<Relationships> findAll() {
        return repository.findAll();
    }
}
