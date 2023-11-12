package com.dating.service.impl;

import com.dating.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Setter
@Getter
public class AccountDetail implements UserDetails {

    private static final long serialVersionUID = 10L;
    private Integer id;
    private String username;

    @JsonIgnore
    private String password;

    GrantedAuthority authorities = null;

    public AccountDetail(Integer id, String username,
                         String password, GrantedAuthority authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static AccountDetail build(Account account) {
        GrantedAuthority authorities = (GrantedAuthority) account.getRole();

        return new AccountDetail(
                account.getId(),
                account.getUserName(),
                account.getEncryptPassword(),
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
