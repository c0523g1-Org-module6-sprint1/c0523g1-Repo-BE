package com.dating.repository.security;

import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ISecurityRepository extends JpaRepository<Account, Integer> {

    /**
     * method findAccountByUserName
     * Create ThienBB
     * Date 15-11-2023
     * param String userName
     * return Account
     */
    @Query(value = " select * from accounts where user_name like :name and is_deleted = 0 ", nativeQuery = true)
    Account findByUserName(@Param("name") String name);
}


