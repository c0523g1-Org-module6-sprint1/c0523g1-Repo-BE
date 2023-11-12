package com.dating.service.HauNH;

import com.dating.model.HauNH.AccountTypes;
import com.dating.repository.HauNH.IAccountTypesRepository;
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
