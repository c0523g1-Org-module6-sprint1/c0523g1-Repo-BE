package com.dating.repository.account;

import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IChangePasswordRepository extends JpaRepository<Account,Integer> {
    /**
     * method findAccountByUsername
     * Create QuyNP
     * Date 13-11-2023
     * return Account
     */
    @Query(value = "SELECT *  FROM accounts  WHERE user_name = :username",nativeQuery = true)
    Account findUsername(@Param("username") String username);


    /**
     * method changePassword
     * Create QuyNP
     * Date 13-11-2023
     */

    @Modifying
    @Transactional
    @Query(value = "UPDATE accounts  SET password = :password WHERE user_name = :username",nativeQuery = true)
    void changePassword(@Param("username") String username, @Param("password") String password);

    /**
     * method findMoney
     * Create QuyNP
     * Date 13-11-2023
     * return Double money
     */

    @Query(value = "SELECT money FROM accounts  WHERE user_name = :name",nativeQuery = true)
    Double findMoney(@Param("name") String name);


    /**
     * method updateMoney
     * Create QuyNP
     * Date 13-11-2023
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE accounts  SET money = :money WHERE user_name = :username",nativeQuery = true)
    void updateMoney(@Param("username") String username, @Param("money") Double money);
    /**
     * method givePoint
     * Create QuyNP
     * Date 13-11-2023
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE accounts  SET point = :result WHERE user_name = :username",nativeQuery = true)
    void givePoint(@Param("username") String username,@Param("result") int result);
}
