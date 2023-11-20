package com.dating.service.account;

import com.dating.dto.account.AccountDTOs;
import com.dating.dto.account.AccountDto;
import com.dating.model.account.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface IAccountService extends UserDetailsService {
    /**
     * method findByUsername
     * Create SangPQ
     * Date 13-11-2023
     * param String userName
     * return Account or null
     */
    Account findByUsername(String userName);

    /**
     * method findByEmail
     * Create SangPQ
     * Date 13-11-2023
     * param String email
     * return Account or null
     */
    Account findByEmail(String email);


    Page<AccountDTOs> findAll(Pageable pageable, String username, String typeAccount);
    /**
     * method createNewAccount
     * Create SangPQ
     * Date 16-11-2023
     * param Account account
     * return Boolean
     */
    Boolean createNewAccount(Account account);

    Page<Account> findAll(Pageable pageable,String username);
  
    void deleteAccount(Integer id);

    /**
     * method findAccountById
     * Create SangPQ
     * Date 13-11-2023
     * param Integer id
     * return Account
     */
    Account findAccountById(Integer id);
    void updateAccount(Account account);



    //LongTND triển khai
    Account findByID(Integer id);

    //LongTND triển khai
    Account findAccountByUserName(String name);

    Account setEditAccount(AccountDto accountDto);

}
