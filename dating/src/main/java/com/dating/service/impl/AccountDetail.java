package com.dating.service.impl;

import com.dating.model.Role;
import com.dating.model.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Getter
@Setter
public class AccountDetail implements UserDetails {

    private static final long serialVersionUID = 10L;
    private Integer id;
    private String username;

    @JsonIgnore
    private String password;

    List<GrantedAuthority> authorities = null;

    public AccountDetail(Integer id, String username,
                         String password, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    /**
     * method Create Account Detail
     * Create ThienBB
     * Date 13-11-2023
     * param Account account
     * return new Object: AccountDetail
     */
    public static AccountDetail build(Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Role role = account.getRole();
        if (role != null) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new AccountDetail(
                account.getId(),
                account.getUserName(),
                account.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return (Collection<? extends GrantedAuthority>) authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
