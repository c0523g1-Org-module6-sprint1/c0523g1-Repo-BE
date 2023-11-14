package com.dating.repository.relationship;

import com.dating.dto.relationship.IFriendDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IRelationshipRepository {
    /**
     * method findAllFriendByName
     * Create: 13-11-2023
     * return: List friend
     * author: ThienPT
     */

    @Query(value = "SELECT " +
            "acc.id AS id, " +
            "acc.name AS nameAccount, " +
            "l.name AS nameLocation, " +
            "g.name AS nameGender, " +
            "acc.avatar AS avatarAccount, " +
            "acc.birthday AS birthdayAccount " +
            "FROM accounts acc " +
            "JOIN location l ON acc.location_id = l.id " +
            "JOIN genders g ON acc.gender_id = g.id " +
            "JOIN ( " +
            "    SELECT rel.relationship_status_id, rel.receiver_account_id, rel.sender_account_id, relta.name " +
            "    FROM relationships rel " +
            "    JOIN relationship_status relta ON rel.relationship_status_id = relta.id " +
            "    WHERE rel.relationship_status_id = 2 " +
            "        AND (rel.receiver_account_id = 1 XOR rel.sender_account_id = 1) " +
            ") subquery ON acc.id = CASE " +
            "    WHEN subquery.receiver_account_id = 1 THEN subquery.sender_account_id " +
            "    ELSE subquery.receiver_account_id " +
            "END " +
            "WHERE acc.name LIKE CONCAT('%', :name, '%')",nativeQuery = true)
    List<IFriendDto> findAllFriendByName(@Param("name") String name);

    /**
     * method delete
     * Create: 14-11-2023
     * return: void
     * author: ThienPT
     */
    @Transactional
    @Modifying
    @Query(value =
            "update relationships as rel set rel.relationship_status_id = 3 " +
                    "where (rel.receiver_account_id = :idLogin and rel.sender_account_id = :idFriend) " +
                    "or  (rel.receiver_account_id = :idFriend and rel.sender_account_id = :idLogin);",nativeQuery = true)
    void blockFriend(@Param("idLogin") Integer idLogin, @Param("idFriend") Integer idFriend);


    @Transactional
    @Modifying
    @Query(value = "update relationships as rel set rel.is_deleted = 1 " +
            "where (rel.receiver_account_id = :idLogin and rel.sender_account_id = :idFriend) " +
            "or  (rel.receiver_account_id = :idFriend and rel.sender_account_id = :idLogin)",nativeQuery = true)
    void unFriend(@Param("idLogin") Integer idLogin, @Param("idFriend") Integer idFriend);
}
