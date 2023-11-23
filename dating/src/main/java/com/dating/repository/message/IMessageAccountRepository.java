package com.dating.repository.message;

import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IMessageAccountRepository extends JpaRepository<Account, Integer> {
    /**
     * method selectAccountById
     * Create ThangLQ
     * Date 13-11-2023
     * return Account
     */
    @Query(nativeQuery = true, value = "select * from accounts where id = :id and is_deleted = 0")
    Account selectAccountById (@Param("id") Integer id);

    /**
     * method setBusy
     * Create ThangLQ
     * Date 13-11-2023
     * return void
     */
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update accounts set message_status_id = :status where (id = :id)")
    void setBusy(@Param("status") Integer status, @Param("id") Integer id);

    /**
     * method getFriendList
     * Create ThangLQ
     * Date 13-11-2023
     * return List<Account>
     */
    @Query(nativeQuery = true, value = "select * from ( " +
            "select accounts.* from relationships " +
            "left join relationship_status on relationship_status.id = relationships.relationship_status_id " +
            "inner join accounts on accounts.id = relationships.receiver_account_id " +
            "where relationship_status.name like 'friend' and relationships.sender_account_id = :accountId and accounts.name like :name " +
            "union " +
            "select accounts.* from relationships " +
            "left join relationship_status on relationship_status.id = relationships.relationship_status_id " +
            "inner join accounts on accounts.id = relationships.sender_account_id " +
            "where relationship_status.name like 'friend' and relationships.receiver_account_id = :accountId and accounts.name like :name) as sub " +
            "order by sub.message_status_id ")
    List<Account> getFriendList (@Param("accountId") Integer id, @Param("name") String name);

    /**
     * method getUnknowList
     * Create ThangLQ
     * Date 13-11-2023
     * return List<Account>
     */
    @Query(nativeQuery = true, value = "select * from ( " +
            "select accounts.* from messages " +
            "left join accounts on accounts.id = sender_account_id " +
            "where receive_account_id = :accountId and sender_account_id not in ( " +
            "select accounts.id from relationships " +
            "left join relationship_status on relationship_status.id = relationships.relationship_status_id " +
            "inner join accounts on accounts.id = relationships.receiver_account_id " +
            "where relationship_status.name like 'friend' and relationships.sender_account_id = :accountId " +
            "union " +
            "select accounts.id from relationships " +
            "left join relationship_status on relationship_status.id = relationships.relationship_status_id " +
            "inner join accounts on accounts.id = relationships.sender_account_id " +
            "where relationship_status.name like 'friend' and relationships.receiver_account_id = :accountId " +
            ") " +
            "and accounts.name like :name ) as sub " +
            "order by sub.message_status_id ")

    List<Account> getUnknowList (@Param("accountId") Integer id, @Param("name") String name);
}
