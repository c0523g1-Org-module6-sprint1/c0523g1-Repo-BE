package com.dating.service.search_name;

import com.dating.dto.search_name.SearchNameDto;
import com.dating.model.account.Account;

import java.util.List;

public interface ISearchNameService {
    List<SearchNameDto> searchByName(String name);
}
