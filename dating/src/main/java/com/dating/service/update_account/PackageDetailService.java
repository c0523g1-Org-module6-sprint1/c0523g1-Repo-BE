package com.dating.service.update_account;

import com.dating.model.account.Account;
import com.dating.model.update_account.AccountTypes;
import com.dating.model.update_account.PackageDetail;
import com.dating.repository.update_account.IPackageDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PackageDetailService implements IPackageDetailService{
    @Autowired
    private IPackageDetailRepository packageDetailRepository;
    @Override
    public List<PackageDetail> findAll() {
        return packageDetailRepository.findAll();
    }

    @Override
    public void setMoneyAccount(int accountId, int newMoney) {
        packageDetailRepository.setMoneyAccount(accountId, newMoney);
    }

    @Override
    public void setAccountTypes(int accountId, int accountTypesId) {
        packageDetailRepository.setAccountTypes(accountId, accountTypesId);
    }
}
