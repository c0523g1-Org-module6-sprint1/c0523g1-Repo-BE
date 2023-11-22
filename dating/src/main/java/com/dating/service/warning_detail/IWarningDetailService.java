package com.dating.service.warning_detail;

import com.dating.model.warning_detail.WarningDetails;

public interface IWarningDetailService {
    WarningDetails findById(Integer id);

    void save(WarningDetails warningDetails);
    void  lockAccount(WarningDetails warningDetails);

}
