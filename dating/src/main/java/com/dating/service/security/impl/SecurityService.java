package com.dating.service.security.impl;

import com.dating.model.account.Account;
import com.dating.repository.security.ISecurityRepository;
import com.dating.service.security.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SecurityService implements ISecurityService {

    @Autowired
    private ISecurityRepository securityRepository;

    @Override
    public Optional<Account> findByUsername(String name) {
        return Optional.ofNullable(securityRepository.findByUserName(name));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
