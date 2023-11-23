package com.dating.service.security;

import com.dating.model.account.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface ISecurityService extends UserDetailsService {

    Optional<Account> findByUsername(String name);

}
