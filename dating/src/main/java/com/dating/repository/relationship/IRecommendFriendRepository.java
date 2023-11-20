package com.dating.repository.relationship;

import com.dating.dto.relationship.IRecommendFriendDto;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRecommendFriendRepository extends JpaRepository<Relationships, Integer> {
    /**
     * method findAllRecommendFriend
     * Create HungHLP
     * Date 13-11-2023
     * return list  recommend friend
     */



    @Query(value = "SELECT a.name AS nameAccount, g.name AS nameGender, l.name AS nameLocation, j.name AS jobAccount, h.name AS hobbyAccount, a.avatar AS avatarAccount FROM accounts a LEFT JOIN roles r ON a.role_id = r.id\n" +
            "LEFT JOIN genders g ON a.gender_id = g.id\n" +
            "LEFT JOIN location l ON a.location_id = l.id\n" +
            "LEFT JOIN jobs j ON a.job_id = j.id\n" +
            "LEFT JOIN hobby_detail hd ON (hd.account_id = a.id OR hd.hobby_id = a.id)\n" +
            "LEFT JOIN hobbies h ON hd.hobby_id = h.id\n" +
            "LEFT JOIN relationships f ON (f.sender_account_id = :accountID AND f.receiver_account_id = a.id) OR (f.sender_account_id = a.id AND f.receiver_account_id = :accountID)\n" +
            "WHERE a.id <> :accountID\n" +
            "AND a.location_id = (SELECT location_id FROM accounts WHERE id = :accountID)\n" +
            "AND a.job_id = (SELECT job_id FROM accounts WHERE id = :accountID)\n" +
            "AND (hd.account_id = :accountID OR hd.hobby_id = :accountID)\n" +
            "AND a.gender_id = (SELECT gender_id FROM accounts WHERE id = :accountID)\n" +
            "AND f.sender_account_id IS NULL\n" +
            "AND f.receiver_account_id IS NULL;",
            nativeQuery = true)
    List<IRecommendFriendDto> findAllRecommendFriend(@Param("accountID")int accountID);


    /**
     * method sortByLocation
     * Create HungHLP
     * Date 14-11-2023
     * return list  recommend friend sort by location
     */

    @Query(value = "select * from location\n" +
            "        left join accounts on accounts.location_id = location.id\n" +
            "        where location.id = (select accounts.location_id from accounts where accounts.id = :accountID)\n" +
            "        and (accounts.id not in (select relationships.receiver_account_id\n" +
            "        from relationships left join relationship_status on relationships.relationship_status_id = relationship_status.id\n" +
            "        where relationships.sender_account_id = :accountID and not relationship_status.name = \"friend\") or\n" +
            "        accounts.id not in (select relationships.sender_account_id\n" +
            "        from relationships left join relationship_status on relationships.relationship_status_id = relationship_status.id\n" +
            "        where relationships.receiver_account_id = :accountID and not relationship_status.name = \"friend\"));", nativeQuery = true)
    List<IRecommendFriendDto> sortByLocation(@Param("accountID")int accountID);



    /**
     * method sortByHobby
     * Create HungHLP
     * Date 14-11-2023
     * return list  recommend friend sort by hobby
     */
    @Query(value = "SELECT a.name AS nameAccount, g.name AS nameGender, h.name AS hobbyAccount,a.avatar AS avatarAccount FROM accounts a LEFT JOIN roles r ON a.role_id = r.id\n" +
            "LEFT JOIN genders g ON a.gender_id = g.id\n" +
            "LEFT JOIN location l ON a.location_id = l.id\n" +
            "LEFT JOIN jobs j ON a.job_id = j.id\n" +
            "LEFT JOIN hobby_detail hd ON (hd.account_id = a.id OR hd.hobby_id = a.id)\n" +
            "LEFT JOIN hobbies h ON hd.hobby_id = h.id\n" +
            "LEFT JOIN relationships f ON (f.sender_account_id = :accountID AND f.receiver_account_id = a.id) OR (f.sender_account_id = a.id AND f.receiver_account_id = :accountID)\n" +
            "WHERE a.id <> :accountID\n" +
            "AND a.location_id = (SELECT location_id FROM accounts WHERE id = :accountID)\n" +
            "AND a.job_id = (SELECT job_id FROM accounts WHERE id = :accountID)\n" +
            "AND (hd.account_id = :accountID OR hd.hobby_id = :accountID)\n" +
            "AND a.gender_id = (SELECT gender_id FROM accounts WHERE id = :accountID)\n" +
            "AND f.sender_account_id IS NULL\n" +
            "AND f.receiver_account_id IS NULL;", nativeQuery = true)
    List<IRecommendFriendDto> sortByHobby(@Param("accountID")int accountID);



    /**
     * method sortByJob
     * Create HungHLP
     * Date 14-11-2023
     * return list  recommend friend sort by job
     */
    @Query(value = " select * from jobs\n" +
            "        left join accounts on accounts.job_id = job_id\n" +
            "        where job_id = (select accounts.job_id from accounts where accounts.id = :accountID)\n" +
            "        and (accounts.id not in (select relationships.receiver_account_id\n" +
            "        from relationships left join relationship_status on relationships.relationship_status_id = relationship_status.id\n" +
            "        where relationships.sender_account_id = :accountID and not relationship_status.name = \"friend\") or\n" +
            "        accounts.id not in (select relationships.sender_account_id\n" +
            "        from relationships left join relationship_status on relationships.relationship_status_id = relationship_status.id\n" +
            "        where relationships.receiver_account_id = :accountID and not relationship_status.name = \"friend\"));", nativeQuery = true)
    List<IRecommendFriendDto> sortByJob(@Param("accountID")int accountID);

}
