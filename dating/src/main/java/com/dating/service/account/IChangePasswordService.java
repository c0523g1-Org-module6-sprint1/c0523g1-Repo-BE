package com.dating.service.account;

import com.dating.model.account.Account;

public interface IChangePasswordService {
    void update(String name, String newPassword);
    Account findPassword(String name);

    Double findMoney(String name);

    boolean updateMoney(double money, String userName);

    void giftPoint(String name, int resultPoint);
}
