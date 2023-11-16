package com.dating.service.search_name;

import com.dating.dto.search_name.SearchNameDto;
import com.dating.model.account.Account;
import com.dating.repository.search_name.ISearchNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchNameService implements ISearchNameService {
    @Autowired
    private ISearchNameRepository accountRepository;
    @Override
    public List<SearchNameDto> searchByName(String name) {
        return accountRepository.findAccountByName(name);
    }

}
