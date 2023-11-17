package com.dating.service.search_advanced_top_100;

import com.dating.dto.search_advanced.SearchAdvanced;
import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.dto.top_100.TopHunderedDto;
import com.dating.repository.search_advanced_top_100.IAccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService implements IAccountsService {
    @Autowired
    private IAccountsRepository accountsRepository;

    @Override
    public List<SearchAvancedDto> getAll(SearchAdvanced searchAdvanced) {
        return accountsRepository.findAll("%" + searchAdvanced.getName() + "%", searchAdvanced.getBirthdayFrom(), searchAdvanced.getBirthdayEnd(), searchAdvanced.getGender(), searchAdvanced.getLocation(), searchAdvanced.getJob(), searchAdvanced.getHobby());
    }

    @Override
    public List<TopHunderedDto> findAll() {
        return accountsRepository.findAllByAccount();
    }

}
