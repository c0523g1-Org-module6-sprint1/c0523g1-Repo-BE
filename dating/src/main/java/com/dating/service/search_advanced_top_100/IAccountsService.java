package com.dating.service.search_advanced_top_100;

import com.dating.model.account.Account;

import java.util.List;

public interface IAccountsService {
    List<Account> getAll(String name, String birthday, int genderId, int hobbyId, int locationId, int jobId, int hobbyDetailId);

    List<Account> findAll();
}
