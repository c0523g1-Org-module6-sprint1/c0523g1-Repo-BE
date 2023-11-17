package com.dating.service.relationship;

import com.dating.dto.relationships.IRelationshipsDTO;
import com.dating.model.relationship.RelationshipStatus;
import com.dating.model.relationship.Relationships;

public interface ISendInvitedService{
    void saveInvited(Relationships relationships);
    Relationships getRelationshipsStatus(int idSent, int idReceiver);

}
