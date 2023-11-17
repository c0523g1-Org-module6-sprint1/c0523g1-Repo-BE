package com.dating.service.account;
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
    public Boolean createNewAccount(Account account) {
        Account newAccount = accountRepository.findAccountByUserName(account.getUserName());
        if (newAccount == null){
            Integer amount = accountRepository.createNewAccount(account);
//            Account accountAfterCreate = accountRepository.findAccountByUserName(account.getUserName());
            return amount > 0;
        }
        return false;
    }

    @Override
    public Page<Account> findAll(Pageable pageable, String username) {
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
        accountRepository.EditAccount(account);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
