package com.dating.service.account;

import com.dating.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;




public interface IAccountService extends UserDetailsService {
    Account findByUsername(String userName);
    Account findByEmail(String email);
    Boolean createNewAccount(Account account);
    Page<Account> findAll(Pageable pageable,String username);
    void deleteAccount(Integer id);

    Account findById(Integer id);
}
