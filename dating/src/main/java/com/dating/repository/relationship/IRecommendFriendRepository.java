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
     * param String name
     * return list  recommend friend
     */
    @Query(value = "SELECT a.id, a.name\n" +
            "FROM Account a\n" +
            "LEFT JOIN Relationships r ON (r.senderAccount.id = a.id OR r.receiverAccount.id = a.id)\n" +
            "WHERE r.id IS NULL\n" +
            "  AND a.id <> 1\n" +
            "  AND (a.hobbyDetailSet IS NOT NULL\n" +
            "       OR a.job IS NOT NULL\n" +
            "       OR a.location IS NOT NULL)\n" +
            "  AND (a.hobbyDetailSet = (\n" +
            "         SELECT hobbyDetailSet\n" +
            "         FROM Account\n" +
            "         WHERE id = 1\n" +
            "       ) OR a.job = (\n" +
            "         SELECT job\n" +
            "         FROM Account\n" +
            "         WHERE id = 1\n" +
            "       ) OR a.location = (\n" +
            "         SELECT location\n" +
            "         FROM Account\n" +
            "         WHERE id = 1\n" +
            "       ));",
            nativeQuery = true)
    List<IRecommendFriendDto> findAllRecommendFriend(@Param("name") String name);

}
