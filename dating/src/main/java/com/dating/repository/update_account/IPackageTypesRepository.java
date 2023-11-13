package com.dating.repository.update_account;

import com.dating.model.update_account.PackageTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPackageTypesRepository extends JpaRepository<PackageTypes, Integer> {
    @Query(value = "select package_types.* from package_types " +
            "join account_types on account_types.id = package_types.account_type_id " +
            "join package_detail on package_detail.account_type_id = account_types.id " +
            "join accounts on accounts.id = package_detail.account_id;", nativeQuery = true)
    List<PackageTypes> findAll();
}
