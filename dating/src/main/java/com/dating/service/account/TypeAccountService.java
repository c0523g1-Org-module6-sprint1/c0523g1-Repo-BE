package com.dating.service.account;

import com.dating.model.update_account.AccountTypes;
import com.dating.repository.account.ITypeAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAccountService implements ITypeAccountService {
    @Autowired
    private ITypeAccountRepository iTypeAccountRepository;

    @Override
    public List<AccountTypes> findTypeAccount() {
        return iTypeAccountRepository.displayTypeAccount();
    }
}
