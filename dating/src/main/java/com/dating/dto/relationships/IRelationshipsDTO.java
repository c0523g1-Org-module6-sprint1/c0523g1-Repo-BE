package com.dating.dto.relationships;

public interface IRelationshipsDTO {
    int getId();
    boolean getIsDeleted();
    int getRelationshipStatus();
    int getSenderAccount();
    int getReceiverAccount();

}
