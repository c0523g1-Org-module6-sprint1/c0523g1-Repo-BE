package com.dating.service.account;

import com.dating.model.account.Account;
import com.dating.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService{
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public Page<Account> findAll(Pageable pageable,String username) {
        return iAccountRepository.findAllAccount(pageable,username);
    }

    @Override
    public void deleteAccount(Integer id) {
        iAccountRepository.deleteAccountId(id);
    }
}
