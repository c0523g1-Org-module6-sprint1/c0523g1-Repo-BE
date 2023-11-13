package com.dating.repository.account;

import com.dating.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Integer> {

    /**
     * method findAccountByUserName
     * Create SangPQ
     * Date 13-11-2023
     * param String userName
     * return Account
     */
    @Query(value = " select *. from accounts " +
            " where user_name like :username" +
            " and is_deleted = 0 ",
            nativeQuery = true)
    Account findAccountByUserName(@Param("username") String username);

    Account findAccountByUserNameAndAndIsDeletedIsFalse(String username);





/**
 * author: TriVN
 * date: 13/11/2023
 * goal: display account
 * @return HttpStatus
 */

    @Query(value = "select * from accounts where user_name like :username and is_deleted = 0 ", nativeQuery = true)
    Page<Account> findAllAccount(Pageable pageable, @Param("username") String username);

   


    /**
     * method findAccountByEmail
     * Create SangPQ
     * Date 13-11-2023
     * param String email
     * return Account
     */
    @Query(value = "select *. from accounts " +
            "where email like :email " +
            "and is_deleted = 0",
            nativeQuery = true)
    Account findAccountByEmail(@Param("email") String email);

    /**
     * method findAccountById
     * Create SangPQ
     * Date 13-11-2023
     * param String email
     * return Account
     */
    @Query(value = "select *. from accounts " +
            "where email like :id " +
            "and is_deleted = 0",
            nativeQuery = true)
    Account findAccountById(@Param("id") int id);

    /**
     * method addNewAccount
     * Create SangPQ
     * Date 13-11-2023
     * param Account account
     * return Integer
     */
    @Modifying
    @Query(value = "INSERT INTO accounts (user_name, password,gender_id, email, location_id)\n" +
            "VALUES (:#{#account.userName},:#{#account.password},:#{#account.gender.id} ,:#{#account.email},:#{#account.location.id})", nativeQuery = true)
    Integer addNewAccount(Account account);




}
