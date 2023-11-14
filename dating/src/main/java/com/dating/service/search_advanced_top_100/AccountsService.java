package com.dating.service.search_advanced_top_100;

import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.dto.top_100.TopHunderedDto;
import com.dating.model.account.Account;
import com.dating.repository.search_advanced_top_100.IAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService  implements IAccountsService {
    @Autowired
    private IAccountsRepository accountsRepository;

    @Override

    public List<SearchAvancedDto> getAll(String name, String birthday, int genderId, int hobbyId, int locationId, int jobId, int hobbyDetailId) {
        return null;
    }

    @Override
    public List<TopHunderedDto> findAll() {
        return accountsRepository.findAllByAccount();
    }

}
