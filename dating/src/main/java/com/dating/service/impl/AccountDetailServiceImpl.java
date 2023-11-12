package com.dating.service.impl;

import api.model.Account;
import api.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailServiceImpl implements UserDetailsService {
    @Autowired
    IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUserName(username);

        if (account == null) {
            throw new UsernameNotFoundException("User with username: " + username + " was not found in database");
        }
        return AccountDetail.build(account);
    }
}
