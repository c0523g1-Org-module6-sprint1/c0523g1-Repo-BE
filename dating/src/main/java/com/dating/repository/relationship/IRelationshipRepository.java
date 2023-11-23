package com.dating.repository.relationship;

import com.dating.dto.relationship.IFriendDto;
import com.dating.model.relationship.Relationships;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface IRelationshipRepository  extends JpaRepository<Relationships, Integer> {
    /**
     * method findAllFriendByName
     * Create: 13-11-2023
     * return: List friend
     * author: ThienPT
     */

    @Query(value = "SELECT " +
            "acc.id AS id, acc.user_name as usernameAccount, " +
            "acc.name AS nameAccount, " +
            "l.name AS nameLocation, " +
            "g.name AS nameGender, " +
            "acc.avatar AS avatarAccount, " +
            "acc.birthday AS birthdayAccount, " +
            "subquery.relationship_status_id AS idRel, " +
            "subquery.sender_account_id AS idSender " +
            "FROM accounts acc " +
            "JOIN location l ON acc.location_id = l.id " +
            "JOIN genders g ON acc.gender_id = g.id " +
            "JOIN ( " +
            "    SELECT rel.relationship_status_id , rel.receiver_account_id, rel.sender_account_id, relta.name " +
            "    FROM relationships rel " +
            "    JOIN relationship_status relta ON rel.relationship_status_id = relta.id " +
            "    WHERE (rel.receiver_account_id = :idLogin XOR rel.sender_account_id = :idLogin) AND rel.is_deleted = 0" +
            "        AND (rel.relationship_status_id = 2 OR rel.relationship_status_id = 3) " +
            ") subquery ON acc.id = CASE " +
            "    WHEN subquery.receiver_account_id = :idLogin THEN subquery.sender_account_id " +
            "    ELSE subquery.receiver_account_id " +
            "END " +
            "WHERE acc.name LIKE CONCAT('%', :name, '%') ORDER BY idRel ASC ",nativeQuery = true)
    Page<IFriendDto> findAllFriendByName(@Param("idLogin") Integer idLogin, @Param("name") String name, Pageable pageable);

    /**
     * method block
     * Create: 14-11-2023
     * return: void
     * author: ThienPT
     */
    @Transactional
    @Modifying
    @Query(value =
            "update relationships as rel set rel.relationship_status_id = 3 ,rel.receiver_account_id = :idLogin,rel.sender_account_id = :idFriend " +
                    "where (rel.receiver_account_id = :idLogin and rel.sender_account_id = :idFriend) " +
                    "or  (rel.receiver_account_id = :idFriend and rel.sender_account_id = :idLogin);",nativeQuery = true)
    void blockFriend(@Param("idLogin") Integer idLogin, @Param("idFriend") Integer idFriend);


    /**
     * method unblock
     * Create: 14-11-2023
     * return: void
     * author: ThienPT
     */
    @Transactional
    @Modifying
    @Query(value =
            "update relationships as rel set rel.relationship_status_id = 2 " +
                    "where rel.receiver_account_id = :idLogin and rel.sender_account_id = :idFriend ",nativeQuery = true)
    void unblockFriend(@Param("idLogin") Integer idLogin, @Param("idFriend") Integer idFriend);


    /**
     * method unFriend
     * Create: 14-11-2023
     * return: void
     * author: ThienPT
     */
    @Transactional
    @Modifying
    @Query(value = "delete  from relationships as rel  " +
            "where (rel.receiver_account_id = :idLogin and rel.sender_account_id = :idFriend) " +
            "or  (rel.receiver_account_id = :idFriend and rel.sender_account_id = :idLogin)",nativeQuery = true)
    void unFriend(@Param("idLogin") Integer idLogin, @Param("idFriend") Integer idFriend);


}
