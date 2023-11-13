package com.dating.service.update_account;

import com.dating.model.update_account.AccountTypes;
import com.dating.repository.update_account.IAccountTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountTypesService implements IAccountTypesService{
    @Autowired
    private IAccountTypesRepository accountTypesRepository;
    @Override
    public List<AccountTypes> findAll() {
        return accountTypesRepository.findAll();
    }
}
