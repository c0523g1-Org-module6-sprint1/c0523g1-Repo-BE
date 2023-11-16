package com.dating.service.account;
import com.dating.dto.account.AccountDTOs;
import com.dating.model.account.Account;
import com.dating.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account findByUsername(String userName) {
        return accountRepository.findAccountByUserName(userName);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    @Override
    public void createNewAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Page<AccountDTOs> findAll(Pageable pageable, String username) {
        return accountRepository.findAllAccount(pageable, username);
    }

    @Override
    public void deleteAccount(Integer id) {
        accountRepository.deleteAccountId(id);
    }





    @Override
    public Account findAccountById(Integer id) {
        accountRepository.findAccountById(id);
        return null;
    }


    public void updateAccount(Account account) {
        accountRepository.editAccount(account);
    }




    //hàm này LongTND triển khai
    @Override
    public Account findByID(Integer id) {
        return accountRepository.findAccountByID(id);
    }

    @Override
    public Account findAccountByUserName(String name) {
        return accountRepository.getAccountByUserName(name);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
