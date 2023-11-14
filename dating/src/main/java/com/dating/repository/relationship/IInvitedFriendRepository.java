package com.dating.repository.relationship;
import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IInvitedFriendRepository extends JpaRepository<Relationships, Integer> {
    /**
     * method findRelationshipsById
     * Create HungHLP
     * Date 13-11-2023
     * return
     */
    @Query(value = "SELECT relationships.id, relationships.date_request, relationships.is_deleted, accounts.avatar, accounts.name " +
            "FROM relationships JOIN relationship_status ON relationships.relationship_status_id = relationship_status.id " +
            "JOIN accounts ON relationships.sender_account_id = accounts.id OR relationships.receiver_account_id = accounts.id " +
            "WHERE (relationships.sender_account_id = :accountId OR relationships.receiver_account_id = :accountId) " +
            "AND relationship_status.id = 1 AND relationships.is_deleted = false;",
            nativeQuery = true)
//    List<Relationships> findAllInvitedFriend();
    List<IInvitedFriendDto> findAllInvitedFriend();



}
