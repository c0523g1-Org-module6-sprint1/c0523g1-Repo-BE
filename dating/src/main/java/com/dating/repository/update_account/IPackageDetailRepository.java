package com.dating.repository.update_account;
import com.dating.model.account.Account;
import com.dating.model.update_account.PackageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPackageDetailRepository extends JpaRepository<PackageDetail, Integer> {
    @Query(value = "select package_detail.*, accounts.money from package_detail " +
            "join accounts on package_detail.account_id = accounts.id", nativeQuery = true)
    List<PackageDetail> findAll();
    @Query(value = "UPDATE package_detail " +
            "SET money= :newMoney " +
            "WHERE account_id= :accountId", nativeQuery = true)
    void setMoneyAccount(int accountId, int newMoney);

    @Query(value = "UPDATE package_detail " +
            "SET account_types_id= :accountTypesId " +
            "WHERE account_id= :accountId", nativeQuery = true)
    void setAccountTypes(int accountId, int accountTypesId);
}
