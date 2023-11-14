package com.dating.repository.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecommendFriendRepository extends JpaRepository<Relationships, Integer> {
    /**
     * method findRelationshipsById
     * Create HungHLP
     * Date 13-11-2023
     * return list  recommend friend
     */
    @Query(value = "SELECT a.id, a.name " +
            "FROM Account a " +
            "LEFT JOIN Relationships r ON (r.senderAccount.id = a.id OR r.receiverAccount.id = a.id) " +
            "WHERE r.id IS NULL " +
            "  AND a.id <> 1 " +
            "  AND (a.hobbyDetailSet IS NOT NULL " +
            "       OR a.job IS NOT NULL " +
            "       OR a.location IS NOT NULL) " +
            "  AND (a.hobbyDetailSet = ( " +
            "         SELECT hobbyDetailSet " +
            "         FROM Account " +
            "         WHERE id = 1 " +
            "       ) OR a.job = ( " +
            "         SELECT job " +
            "         FROM Account " +
            "         WHERE id = 1 " +
            "       ) OR a.location = ( " +
            "         SELECT location " +
            "         FROM Account " +
            "         WHERE id = 1 " +
            "       ));",
            nativeQuery = true)
    List<IRecommendFriendDto> findAllRecommendFriend();

}
