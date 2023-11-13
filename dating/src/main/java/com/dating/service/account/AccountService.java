package com.dating.service.account;

import com.dating.model.account.Account;
import com.dating.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public Account findByUsername(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    @Override
    public Boolean createNewAccount(Account account) {
        Account currentAccount = accountRepository.findAccountByUserName(account.getUserName());
        if (currentAccount == null){
            Integer amount = accountRepository.addNewAccount(account);
            return amount > 0;
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
