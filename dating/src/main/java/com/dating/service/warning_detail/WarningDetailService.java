package com.dating.service.warning_detail;

import com.dating.model.warning_detail.WarningDetails;
import com.dating.repository.account.IAccountRepository;
import com.dating.repository.warning_detail.IWarningDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarningDetailService implements IWarningDetailService{
    @Autowired
    private IWarningDetailRepository iWarningDetailRepository;
    @Autowired
    private IAccountRepository iAccountRepository;
    @Override
    public WarningDetails findById(Integer id) {
        return iWarningDetailRepository.findByid(id);
    }

    @Override
    public void save(WarningDetails warningDetails) {
        iWarningDetailRepository.save(warningDetails);
    }

//    @Override
//    public void lockAccount(WarningDetails warningDetails) {
//        if (warningDetails.getFaultAmount()== 10){
//            iAccountRepository.deleteAccountId(warningDetails.getAccount().getId());
//        }else if (warningDetails.getFaultAmount()==6){
//            iAccountRepository.deleteAccountId(warningDetails.getAccount().getId());
//        }else if (warningDetails.getFaultAmount()==3){
//            iAccountRepository.deleteAccountId(warningDetails.getAccount().getId());
//        }
//    }




}
