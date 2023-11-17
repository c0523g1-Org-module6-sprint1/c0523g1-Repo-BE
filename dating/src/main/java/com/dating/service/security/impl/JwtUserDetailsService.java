package com.dating.service.security.impl;

import com.dating.dto.JwtResponseUserDetail;
import com.dating.model.account.Account;
import com.dating.repository.security.ISecurityRepository;
import com.dating.service.security.IJwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements IJwtUserDetailsService {


    @Autowired
    private ISecurityRepository securityRepository;

    /**
     * method loadUserByUsername
     * Creator HaiBH
     * Date 14-11-2023
     * param String username
     * return userDetails
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account existedAccount = this.securityRepository.findByUserName(username);

        if (existedAccount == null) {
            throw new UsernameNotFoundException("User with username: " + username + " was not found in database");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(existedAccount.getRole().getName()));
        UserDetails userDetails = new JwtResponseUserDetail(
                existedAccount.getUserName(),
                existedAccount.getPassword(),
                grantedAuthorities
        );
        return userDetails;
    }
}
