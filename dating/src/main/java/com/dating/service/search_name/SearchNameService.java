package com.dating.service.search_name;

import com.dating.dto.search_name.MainPageDto;
import com.dating.dto.search_name.SearchNameDto;
import com.dating.model.account.Account;
import com.dating.repository.search_name.ISearchNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchNameService implements ISearchNameService {
    @Autowired
    private ISearchNameRepository searchNameRepository;
    @Override
    public List<SearchNameDto> searchByName(String name) {
        return searchNameRepository.findAccountByName("%"+name+"%");
    }

    @Override
    public MainPageDto findByUserName(String userName) {
        return searchNameRepository.findByUserName(userName);
    }

}
