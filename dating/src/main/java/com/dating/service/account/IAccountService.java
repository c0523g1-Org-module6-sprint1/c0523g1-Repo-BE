package com.dating.service.account;

import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.hobby.Hobby;
import com.dating.model.hobby_detail.HobbyDetail;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface IAccountService extends UserDetailsService {
    Account findByUsername(String userName);
    Account findByEmail(String email);
    void createNewAccount(Account account);
    Page<Account> findAll(Pageable pageable,String username);
    void deleteAccount(Integer id);
    void findAccountById(Integer id);

    void updateAccount(Account account);

}
