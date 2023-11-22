package com.dating.repository.update_account;
import com.dating.model.account.Account;
import com.dating.model.update_account.PackageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface IPackageDetailRepository extends JpaRepository<PackageDetail, Integer> {
    /**
     * Method: findAll,
     * Create: HauNH,
     * Date  : 13/11/2023
     * param : no
     * return: List<PackageDetail>
     */
    @Query(value = "select package_detail.* from package_detail " +
            "join accounts on package_detail.account_id = accounts.id", nativeQuery = true)
    List<PackageDetail> findAll();

    /**
     * Method: setAccountTypes,
     * Create: HauNH,
     * Date  : 13/11/2023
     * param : int accountId, int accountTypesId
     * return: Update rankings in the account
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE package_detail " +
            "SET account_types_id= :accountTypesId " +
            "WHERE account_id= :accountId", nativeQuery = true)
    void setAccountTypes(int accountId, int accountTypesId);

    /**
     * Method: setMoneyAccount,
     * Create: HauNH,
     * Date  : 13/11/2023
     * param : int accountId, int newMoney
     * return: Update the money field in Account
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE case.accounts " +
            "SET money= :newMoney " +
            "WHERE id= :idAccount", nativeQuery = true)
    void setMoneyAccount(int idAccount, int newMoney);

    @Modifying
    @Transactional
    @Query(value = "UPDATE case.accounts \n" +
            "SET expire = :date, regis_date = :regisDate\n" +
            "WHERE id= :idAccount", nativeQuery = true)
    void registrationDate(LocalDate date, LocalDate regisDate, int idAccount);
}
