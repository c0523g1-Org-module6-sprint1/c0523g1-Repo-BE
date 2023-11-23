package com.dating.repository.account;


import com.dating.model.update_account.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ITypeAccountRepository extends JpaRepository<AccountTypes, Integer> {
    @Query(value = " SELECT account_types.id, account_types.name, account_types.is_deleted FROM account_types  where account_types.is_deleted = false " , nativeQuery = true)
    List<AccountTypes> displayTypeAccount();

    @Transactional
    @Modifying
    @Query(value = "update warning_details set fault_amount = fault_amount +1 where account_id = :id " , nativeQuery = true)
    void warning(Integer id);
}
