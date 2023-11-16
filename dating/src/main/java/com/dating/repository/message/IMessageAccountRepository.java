package com.dating.repository.message;

import com.dating.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IMessageAccountRepository extends JpaRepository<Account, Integer> {
    @Query(nativeQuery = true, value = "select * from accounts where id = :id and is_deleted = 0")
    Account selectAccountById (@Param("id") Integer id);
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update accounts set message_status_id = :status where (id = :id)")
    void setBusy(@Param("status") Integer status, @Param("id") Integer id);
}
