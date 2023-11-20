package com.dating.service.account;

import com.dating.model.update_account.AccountTypes;

import java.util.List;

public interface ITypeAccountService {
    List<AccountTypes> findTypeAccount();
}
