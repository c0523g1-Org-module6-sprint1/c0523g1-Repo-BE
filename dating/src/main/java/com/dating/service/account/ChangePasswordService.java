package com.dating.service.account;

import com.dating.model.account.Account;
import com.dating.repository.account.IChangePasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService implements IChangePasswordService {
    @Autowired
    private IChangePasswordRepository iChangePasswordRepository;

    /**
     * method update
     * Create QuyNP
     * Date 13-11-2023
     */

    @Override
    public void update(String name, String newPassword) {
        iChangePasswordRepository.changePassword(name, newPassword);
    }


    /**
     * method findPassword
     * Create QuyNP
     * Date 13-11-2023
     * return Account
     */

    @Override
    public Account findPassword(String name) {
        return iChangePasswordRepository.findUsername(name);
    }


    /**
     * method findMoney
     * Create QuyNP
     * Date 13-11-2023
     * return Double money
     */

    @Override
    public Double findMoney(String name) {
        return iChangePasswordRepository.findMoney(name);
    }

    /**
     * method updateMoney
     * Create QuyNP
     * Date 13-11-2023
     * return boolean
     */

    @Override
    public boolean updateMoney(double money, String userName) {
        double money1 = findMoney(userName);
        if (money * 100 > money1) {
            return false;
        }
        Double result = money1 - money * 100;
        iChangePasswordRepository.updateMoney(userName, result);
        return true;
    }

    @Override
    public void giftPoint(String name, int resultPoint) {
        Account account = findPassword(name);
        int point = account.getPoint() + resultPoint;
        iChangePasswordRepository.givePoint(name, point);
    }
}
