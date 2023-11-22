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

    @Query(value = " SELECT\n" +
            "    relationships.id AS id,\n" +
            "    relationships.date_request AS dateRequest,\n" +
            "    accounts.avatar AS avatarAccount,\n" +
            "    accounts.name AS nameAccount,\n" +
            "    relationships.sender_account_id AS sendID \n" +
            "FROM\n" +
            "    relationships\n" +
            "JOIN\n" +
            "    accounts ON relationships.sender_account_id = accounts.id\n" +
            "WHERE\n" +
            "    relationships.relationship_status_id = 1\n" +
            "    AND relationships.receiver_account_id = :accountID\n" +
            "GROUP BY\n" +
            "    relationships.id,\n" +
            "    relationships.date_request,\n" +
            "    accounts.avatar,\n" +
            "    accounts.name\n" +
            "    ORDER BY relationships.date_request DESC",
            nativeQuery = true)
    List<IInvitedFriendDto> findAllInvitedFriend(@Param("accountID") Integer accountID);


    @Query(value = "  SELECT\n" +
            "  accounts.id AS accountID , relationships.id AS id,\n" +
            "    relationships.date_request AS dateRequest,\n" +
            "    accounts.avatar AS avatarAccount,\n" +
            "    accounts.name AS nameAccount,\n" +
            "    genders.name AS genderName,\n" +
            "    MIN(relationships.sender_account_id) \n" +
            "FROM\n" +
            "    relationships\n" +
            "    JOIN relationship_status ON relationships.relationship_status_id = relationship_status.id\n" +
            "    JOIN accounts ON relationships.sender_account_id = accounts.id\n" +
            "    JOIN \n" +
            "    genders ON accounts.gender_id = genders.id -- Assuming genders table has an account_id column\n" +
            "WHERE\n" +
            "    relationships.relationship_status_id = 1\n" +
            "    AND relationships.receiver_account_id = :accountID\n" +
            "GROUP BY\n" +
            "    relationships.id,\n" +
            "    relationships.date_request,\n" +
            "    relationships.is_deleted,\n" +
            "    accounts.avatar,\n" +
            "    accounts.name,\n" +
            "    genders.name ORDER BY relationships.date_request DESC",
            nativeQuery = true)
    List<IInvitedFriendDto> sortByDateRequestDesc(@Param("accountID") Integer accountID);

    @Query(value = "  SELECT\n" +
            "     accounts.id AS accountID , relationships.id AS id,\n" +
            "    relationships.date_request AS dateRequest,\n" +
            "    accounts.avatar AS avatarAccount,\n" +
            "    accounts.name AS nameAccount,\n" +
            "    genders.name AS genderName,\n" +
            "     MIN(relationships.sender_account_id) \n" +
            "FROM\n" +
            "    relationships\n" +
            "    JOIN relationship_status ON relationships.relationship_status_id = relationship_status.id\n" +
            "    JOIN accounts ON relationships.sender_account_id = accounts.id\n" +
            "    JOIN \n" +
            "    genders ON accounts.gender_id = genders.id -- Assuming genders table has an account_id column\n" +
            "WHERE\n" +
            "    relationships.relationship_status_id = 1\n" +
            "    AND relationships.receiver_account_id = :accountID\n" +
            "GROUP BY\n" +
            "    relationships.id,\n" +
            "    relationships.date_request,\n" +
            "    relationships.is_deleted,\n" +
            "    accounts.avatar,\n" +
            "    accounts.name,\n" +
            "    genders.name  ORDER BY relationships.date_request ASC ",
            nativeQuery = true)
    List<IInvitedFriendDto> sortByDateRequestAsc(@Param("accountID") Integer accountID);

    /**
     * method accecptFriend
     * Create HungHLP
     * Date 13-11-2023
     * return loginID, sendAccount
     */


    @Modifying
    @Transactional
    @Query(value = " UPDATE relationships SET relationship_status_id = 2 WHERE id = :invitedID",nativeQuery = true)
    void acceptInvited(@Param("invitedID") Integer invitedID);

}
