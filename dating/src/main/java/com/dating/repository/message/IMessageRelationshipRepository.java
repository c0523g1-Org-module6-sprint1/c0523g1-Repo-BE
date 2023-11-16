package com.dating.repository.message;

import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMessageRelationshipRepository extends JpaRepository<Relationships, Integer> {
    @Query(nativeQuery = true, value = "select * from relationships " +
            "left join relationship_status on relationship_status.id = relationships.relationship_status_id " +
            "where relationship_status.name = 'Friend' and (relationships.receiver_account_id = :id or relationships.sender_account_id = :id)")
    List<Relationships> findFriendListByAccountId(@Param("id") Integer id);
}
