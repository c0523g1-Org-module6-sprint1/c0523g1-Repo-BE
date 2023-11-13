package com.dating.service.account;

import com.dating.model.account.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Account findByUsername(String userName);
    Account findByEmail(String email);
    Boolean createNewAccount(Account account);
}
