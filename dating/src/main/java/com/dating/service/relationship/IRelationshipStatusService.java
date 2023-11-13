package com.dating.service.relationship;

import com.dating.model.relationship.RelationshipStatus;

public interface IRelationshipStatusService {

    RelationshipStatus findStatusByID(int id);
}
