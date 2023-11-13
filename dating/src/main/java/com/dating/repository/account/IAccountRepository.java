package com.dating.repository.account;

import com.dating.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = " select *. from accounts " +
            " where user_name like :username" +
            " and is_deleted = 0 ",
            nativeQuery = true)
    Account findAccountByUserName(@Param("username") String username);



/**
 * author: TriVN
 * date: 13/11/2023
 * goal: display account
 * @return HttpStatus
 */

    @Query(value = "select * from accounts where user_name like :username and is_deleted = 0 ", nativeQuery = true)
    Page<Account> findAllAccount(Pageable pageable, @Param("username") String username);
}
