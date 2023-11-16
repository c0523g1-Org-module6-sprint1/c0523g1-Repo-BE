package com.dating.service.account;

import com.dating.dto.account.AccountDTOs;
import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface IAccountService extends UserDetailsService {
    Account findByUsername(String userName);
    Account findByEmail(String email);
    Boolean createNewAccount(Account account);
    Page<AccountDTOs> findAll(Pageable pageable, String username);
    void deleteAccount(Integer id);
    Account findAccountById(Integer id);
    Gender findGender(Integer genderId);
    Location findLocation(Integer locationId);
    Job findJob(Integer jobId);
    void updateAccount(Account account);


}
