package com.dating.service.impl;

import com.dating.model.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AccountDetail implements UserDetails {

    private static final long serialVersionUID = 10L;
    private Integer id;
    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public AccountDetail(Integer id, String username,
                         String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static AccountDetail build(Account account) {
        List<GrantedAuthority> authorities = account.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collection(Collectors.toList());

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
