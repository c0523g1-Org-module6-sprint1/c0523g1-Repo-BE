package com.dating.repository.relationship;
import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface IInvitedFriendRepository extends JpaRepository<Relationships,Integer> {

    /**
     * method findInvitedFriend
     * Create HungHLP
     * Date 13-11-2023
     * return
     */

    @Query(value = "SELECT\n" +
            "    relationships.id AS id,\n" +
            "    relationships.date_request AS dateRequest,\n" +
            "    accounts.avatar AS avatarAccount,\n" +
            "    accounts.name AS nameAccount,\n" +
            "    MIN(relationships.sender_account_id) AS sendID \n" +
            "FROM\n" +
            "    relationships\n" +
            "        JOIN\n" +
            "    relationship_status ON relationships.relationship_status_id = relationship_status.id\n" +
            "        JOIN\n" +
            "    accounts ON relationships.sender_account_id = accounts.id\n" +
            "WHERE\n" +
            "    relationships.relationship_status_id = 1\n" +
            "    AND relationships.receiver_account_id = :accountID\n" +
            "GROUP BY\n" +
            "relationships.id,\n" +
            "    relationships.date_request,\n" +
            "    relationships.is_deleted,\n" +
            "    accounts.avatar,\n" +
            "    accounts.name;",
            nativeQuery = true)
    List<IInvitedFriendDto> findAllInvitedFriend(@Param("accountID") Integer accountID);


    @Query(value = "SELECT accounts.id, accounts.avatar, accounts.name, relationships.date_request \n" +
            "FROM relationships\n" +
            "LEFT JOIN relationship_status ON relationships.relationship_status_id = relationship_status.id\n" +
            "LEFT JOIN accounts ON relationships.receiver_account_id = accounts.id\n" +
            "WHERE relationship_status.name = \"pending\" \n" +
            "    AND relationships.receiver_account_id = 2 \n" +
            "    AND relationships.is_deleted = 0 \n" +
            "    AND (NOT relationships.receiver_account_id = relationships.sender_account_id)\n" +
            "ORDER BY relationships.date_request DESC;",
            nativeQuery = true)
    List<IInvitedFriendDto> sortByDateRequestDesc();

    @Query(value = "SELECT accounts.id, accounts.avatar, accounts.name, relationships.date_request \n" +
            "FROM relationships\n" +
            "LEFT JOIN relationship_status ON relationships.relationship_status_id = relationship_status.id\n" +
            "LEFT JOIN accounts ON relationships.receiver_account_id = accounts.id\n" +
            "WHERE relationship_status.name = \"pending\" \n" +
            "    AND relationships.receiver_account_id = 2 \n" +
            "    AND relationships.is_deleted = 0 \n" +
            "    AND (NOT relationships.receiver_account_id = relationships.sender_account_id)\n" +
            "ORDER BY relationships.date_request ASC",
            nativeQuery = true)
    List<IInvitedFriendDto> sortByDateRequestAsc();

    /**
     * method accecptFriend
     * Create HungHLP
     * Date 13-11-2023
     * return loginID, sendAccount
     */


    @Modifying
    @Transactional
//    @Query(value = "UPDATE relationships AS rel SET rel.relationship_status_id = 2 " +
//            "WHERE (rel.receiver_account_id = :loginAccount AND rel.sender_account_id = :sendAccount) " +
//            "OR (rel.receiver_account_id = :sendAccount AND rel.sender_account_id = :loginAccount)",
//            nativeQuery = true)
    @Query(value = " UPDATE relationships SET relationship_status_id = 2 WHERE id = :invitedID",nativeQuery = true)
    void acceptInvited(@Param("invitedID") Integer invitedID);

}
