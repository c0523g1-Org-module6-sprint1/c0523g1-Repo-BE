package com.dating.repository.update_account;

import com.dating.dto.update_account.PackageDto;
import com.dating.model.update_account.PackageTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IPackageTypesRepository extends JpaRepository<PackageTypes, Integer> {
    @Query(value = "select package_types.* from package_types " +
            "left join account_types on account_types.id = package_types.account_type_id " +
            "left join package_detail on package_detail.account_types_id = account_types.id " +
            "left join accounts on accounts.id = package_detail.account_id " +
            "GROUP BY id", nativeQuery = true)
    List<PackageTypes> findAll();
    @Query(value = "select accounts.money, accounts.`expire`, account_types.`name` from account_types " +
            "left join package_detail on package_detail.account_types_id = account_types.id " +
            "left join accounts on package_detail.account_id = accounts.id \n", nativeQuery = true)
    List<PackageDto> findAllPackageAccount();
}
