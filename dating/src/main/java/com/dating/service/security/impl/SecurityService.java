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

    /**
     * method findByUsername()
     * Create ThienBB
     * Date 13-11-2023
     * param String name
     * return Optional<Account>
     */
    @Override
    public Optional<Account> findByUsername(String name) {
        return Optional.ofNullable(securityRepository.findByUserName(name));
    }

    /**
     * method loadUserByUsername()
     * Create ThienBB
     * Date 13-11-2023
     * param String name
     * return null
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
