package com.dating.service.search_advanced_top_100;

import com.dating.dto.search_advanced.SearchAdvanced;
import com.dating.dto.search_advanced.SearchAvancedDto;
import com.dating.dto.top_100.TopHunderedDto;
import com.dating.model.account.Account;

import java.util.List;

public interface IAccountsService {

    List<SearchAvancedDto> getAll(SearchAdvanced searchAdvanced);

    List<TopHunderedDto> findAll();
}
