package com.dating.repository.account;

import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
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
    @Query(value = " select * from accounts " +
            " where user_name like :username" +
            " and is_deleted = 0 ",
            nativeQuery = true)
    Account findAccountByUserName(@Param("username") String username);

    Account findAccountByUserNameAndAndIsDeletedIsFalse(String username);


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


    /**
     * method findAccountByEmail
     * Create SangPQ
     * Date 13-11-2023
     * param String email
     * return Account
     */
    @Query(value = "select * from accounts " +
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
    @Query(value = "select * from accounts " +
            "where id like :id " +
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


    /**
     * author: TriVN
     * date: 13/11/2023
     * goal: delete account
     *
     * @return HttpStatus
     */
    @Query(value = "UPDATE accounts SET is_deleted = 1", nativeQuery = true)
    void deleteAccountId(@Param("id") Integer id);

    @Query(value = "SELECT * from genders where id = :id", nativeQuery = true)
    Gender findGender(@Param("id") Integer genderId);

    @Query(value = "SELECT * FROM location where id = :id", nativeQuery = true)
    Location findLocation(@Param("id") Integer locationId);

    @Query(value = "select * from jobs where id = :id", nativeQuery = true)
    Job findJob(@Param("id") Integer jobId);
}
