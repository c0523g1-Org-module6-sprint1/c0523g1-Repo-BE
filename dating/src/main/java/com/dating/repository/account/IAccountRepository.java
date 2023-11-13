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
public interface IAccountRepository extends JpaRepository<Account, Integer> {

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


    /**
     * author: TriVN
     * date: 13/11/2023
     * goal: display account
     *
     * @return HttpStatus
     */

    @Query(value = "select acc.user_name as user_name, acc.regis_date as regis_date, acc.money as money,wd.fault_amount as fault_amount,wd.description as description, wd.date as date_warning, acct.name as type_account" +
            "            from warning_details wd" +
            "            JOIN warning w on wd.warning_id = w.id " +
            "            JOIN accounts acc on wd.account_id = acc.id " +
            "            join package_detail pd on pd.account_id = acc.id" +
            "            join account_types acct on acct.id = pd.account_type_id" +
            "            where user_name like :username and  acc.is_deleted = 0;", nativeQuery = true)
    Page<Account> findAllAccount(Pageable pageable, @Param("username") String username);

    Account findAccountByUserNameAndDeletedIsFalse(String username);

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
            "where email like :email " +
            "and is_deleted = 0",
            nativeQuery = true)
    Account findAccountById(@Param("email") int id);


    /**
     * author: TriVN
     * date: 13/11/2023
     * goal: delete account
     *
     * @return HttpStatus
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE accounts SET is_deleted = 1", nativeQuery = true)
    void deleteAccountId(@Param("id") Integer id);
}
