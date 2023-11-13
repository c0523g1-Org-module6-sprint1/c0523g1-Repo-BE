package com.dating.service.relationship;

import com.dating.model.relationship.RelationshipStatus;
import com.dating.repository.relationship.IRelationshipStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipStatusService implements IRelationshipStatusService {

    @Autowired
    private IRelationshipStatusRepository relationshipStatusRepository;

    @Override
    public RelationshipStatus findStatusByID(int id) {
        return relationshipStatusRepository.findRelationshipStatusById(id);
    }
}
