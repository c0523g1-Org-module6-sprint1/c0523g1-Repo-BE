package com.dating.service.update_account;

import com.dating.model.account.Account;
import com.dating.model.update_account.AccountTypes;
import com.dating.model.update_account.PackageDetail;

import java.util.List;

public interface IPackageDetailService {
    List<PackageDetail> findAll();
    void setMoneyAccount(int accountId, int newMoney);
    void setAccountTypes(int accountId, int accountTypesId);
}
