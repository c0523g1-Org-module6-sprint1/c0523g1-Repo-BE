package com.dating.repository.relationship;
import com.dating.dto.relationship.IInvitedFriendDto;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IInvitedFriendRepository extends JpaRepository<Relationships,Integer> {

    /**
     * method findInvitedFriend
     * Create HungHLP
     * Date 13-11-2023
     * return
     */

    @Query(value = " select accounts.id AS id, accounts.avatar AS avatarAccount,accounts.name AS nameAccount, relationships.date_request AS dateRequest from relationships " +
            "        left join relationship_status on relationships.relationship_status_id = relationship_status.id " +
            "        left join accounts on relationships.receiver_account_id = accounts.id " +
            "        where relationship_status.name = \"pending\" and relationships.receiver_account_id = :accountID and relationships.is_deleted = 0 and  " +
            "        (not relationships.receiver_account_id = relationships.sender_account_id);",
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
            "ORDER BY relationships.date_request ASC;",
            nativeQuery = true)
    List<IInvitedFriendDto> sortByDateRequestAsc();


    @Query(value =   "update relationships as rel set rel.relationship_status_id = 2 " +
            "where (rel.receiver_account_id = :accountID and rel.sender_account_id = :accountID) " +
            "or  (rel.receiver_account_id = :idFriend and rel.sender_account_id = :accountID);",nativeQuery = true)
    void acceptInvited(@Param("accountID") Integer accountID, @Param("idFriend") Integer idFriend);
    List<IInvitedFriendDto> acceptInvited();








}
