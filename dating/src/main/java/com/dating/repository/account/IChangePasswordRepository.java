package com.dating.repository.account;

import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IChangePasswordRepository extends JpaRepository<Account,Integer> {
    @Query(value = "")
    void updatePassword(String password);
}
