package com.dating.service.relationship;

import com.dating.model.relationship.Relationships;
import com.dating.repository.relationship.ISendInvitedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendInvitedService  implements ISendInvitedService{

    @Autowired
    private ISendInvitedRepository sendInvitedRepository;

    @Override
    public void saveInvited(Relationships relationships) {
        sendInvitedRepository.saveInvitedFriend(relationships.getDateRequest(),relationships.getRelationshipStatus().getId(),relationships.getSenderAccount().getId(),relationships.getReceiverAccount().getId());
    }
}
