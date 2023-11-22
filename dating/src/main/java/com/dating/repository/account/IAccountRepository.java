package com.dating.repository.account;

import com.dating.dto.account.AccountDTOs;
import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import com.dating.model.hobby_detail.HobbyDetail;
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
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    /**
     * method findAccountByUserName
     * Create SangPQ
     * Date 13-11-2023
     * param String userName
     * return Account or null
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
    @Query(value = " select acc.id as id ,acc.user_name as userName , " +
            " acc.regis_date as regisDate , " +
            " acc.money as money ,  " +
            " wd.fault_amount as faultAmount " +
            " ,wd.`description` as `description` " +
            " , wd.`date` as dateWarning " +
            " , acct.`name` as typeAccount , acc.is_deleted as isDeleted " +
            " from accounts acc " +
            " join warning_details wd on acc.id = wd.account_id  " +
            " JOIN warning w on wd.warning_id =  w.id " +
            " join package_detail pd on acc.id = pd.account_id   " +
            " join account_types acct on pd.account_types_id = acct.id  " +
            " where acc.role_id = 1 and  acc.user_name like concat('%', :username, '%') and acct.`id` like concat('%', :typeAccount, '%')  ", nativeQuery = true)
    Page<AccountDTOs> findAllAccount(Pageable pageable, @Param("username") String username, @Param("typeAccount") String typeAccount);


    /**
     * method findAccountByEmail
     * Create SangPQ
     * Date 13-11-2023
     * param String email
     * return Account or null
     */
    @Query(value = " select * from accounts " +
            " where email like :email " +
            " and is_deleted = 0 ",
            nativeQuery = true)
    Account findAccountByEmail(@Param("email") String email);

    /**
     * method findAccountById
     * Create SangPQ
     * Date 13-11-2023
     * param String email
     * return Account or null
     */
    @Query(value = " select * from accounts " +
            " where id = :id " +
            " and is_deleted = 0 ",
            nativeQuery = true)
    Account findAccountById(@Param("id") Integer id);


    /**
     * method addNewAccount
     * Create SangPQ
     * Date 13-11-2023
     * param Account account
     * return Integer
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO accounts (user_name, password,gender_id, email, location_id) " +
            "VALUES (:#{#account.userName},:#{#account.password},:#{#account.gender.id} ,:#{#account.email},:#{#account.location.id})", nativeQuery = true)
    Integer addNewAccount(Account account);


    /**
     * author: TriVN
     * date: 13/11/2023
     * goal: block account
     *
     * @return HttpStatus
     */
    @Transactional
    @Modifying
    @Query(value = " UPDATE accounts SET is_deleted = 1 where accounts.id = :id ", nativeQuery = true)
    void lockAccountId(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = " UPDATE accounts SET is_deleted = 0 where accounts.id = :id ", nativeQuery = true)
    void unlockAccount(@Param("id") Integer id);


    /**
     * author: thienlch
     * date: 13/11/2023
     * goal: edit account
     * @return void
     */
    @Transactional
    @Modifying
    @Query(value = "update accounts set name = :#{#account.name}, gender_id = :#{#account.gender.id}," +
            "birthday = :#{#account.birthday}, location_id = :#{#account.location.id}, avatar = :#{#account.avatar}" +
            "job_id = :#{#account.job.id} where id = :#{#account.id} ", nativeQuery = true)
    void editAccount(@Param("account") Account account);


    /**
     * method createNewAccount
     * Create SangPQ
     * Date 16-11-2023
     * param Account account
     * return Integer
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO accounts (user_name, password, email, birthday, gender_id, location_id, job_id,role_id) \n" +
            "VALUES (:#{#account.userName}, :#{#account.password}, :#{#account.email}, :#{#account.birthday}, \n" +
            "        :#{#account.gender.id}, :#{#account.location.id}, :#{#account.job.id}, 2)",nativeQuery = true)
    Integer createNewAccount(Account account);


    /**
     * author: LongTND
     * date :14/11/2023
     * goal: get account by ID
     * @return account
     */
    @Query(value = "select * from accounts " +
            "where id = :id " +
            "and is_deleted = 0",
            nativeQuery = true)
    Account findAccountByID(@Param("id") int id);

    /**
     * author: LongTND
     * date: 14/11/2023
     * goal: get account by user_name
     * @return account
     */
    @Query(value = "select * from accounts where user_name = :user_name", nativeQuery = true)
    Account getAccountByUserName(@Param("user_name") String userName);


    /**
     * TriVN
     * find by id all
     * @param id
     * @return
     */
    @Query(value = "select * from accounts " +
            "where id = :id " ,
            nativeQuery = true)
    Account findByIdUnlock(Integer id);
    /**
     * method addNewHobbyDetail
     * Create SangPQ
     * Date 17-11-2023
     * param HobbyDetail hobbyDetail
     * return Integer
     */

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO hobby_detail (account_id, hobby_id) \n" +
            "VALUES (:#{#hobbyDetail.account.id}, :#{#hobbyDetail.hobby.id})",nativeQuery = true)
    Integer addNewHobbyDetail(HobbyDetail hobbyDetail);







}




