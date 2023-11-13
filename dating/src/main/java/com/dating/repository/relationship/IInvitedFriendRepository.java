package com.dating.repository.relationship;

import com.dating.model.account.Account;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInvitedFriendRepository extends JpaRepository<Relationships, Integer> {
    /**
     * method findAccountByUserName
     * Create HungHLP
     * Date 13-11-2023
     * param String userName
     * return Account
     */
    @Query(value = " select *. from accounts " +
            " where user_name like :username" +
            " and is_deleted = 0 ",
            nativeQuery = true)
    Relationships findAccountByUserName(@Param("username") String username);

}
