package com.dating.service.impl;

import com.dating.model.account.Account;
import com.dating.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account existedAccount = this.accountRepository.findAccountByUserNameAndAndIsDeletedIsFalse(username);

        if (existedAccount == null) {
            throw new UsernameNotFoundException("User with username: " + username + " was not found in database");
        }
        return new org.springframework.security.core.userdetails.User(
                existedAccount.getUserName(),
                existedAccount.getPassword(),
                new ArrayList<>());
    }
}
