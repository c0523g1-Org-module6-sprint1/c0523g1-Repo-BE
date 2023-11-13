package com.dating.service.impl;


import com.dating.model.account.Account;
import com.dating.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountDetailServiceImpl implements UserDetailsService {
    @Autowired
    IAccountRepository accountRepository;


    /**
     * method loadUserByUsername
     * Create ThienBB
     * Date 13-11-2023
     * param String username
     * return new Object: AccountDetail.build
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUserNameAndAndIsDeletedIsFalse(username);

        if (account == null) {
            throw new UsernameNotFoundException("User with username: " + username + " was not found in database");
        }
        return AccountDetail.build(account);
    }
}
