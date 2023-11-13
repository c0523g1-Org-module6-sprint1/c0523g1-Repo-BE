package com.dating.service.account;
import com.dating.model.account.Account;
import com.dating.model.gender.Gender;
import com.dating.model.job.Job;
import com.dating.model.location.Location;
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
        Account currentAccount = accountRepository.findAccountByUserName(account.getUserName());
        if (currentAccount == null) {
            Integer amount = accountRepository.addNewAccount(account);
            return amount > 0;
        }
        return null;
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
    public void findAccountById(Integer id) {
        accountRepository.findAccountById(id);
    }

    @Override
    public Gender findGender(Integer genderId) {
        return accountRepository.findGender(genderId);
    }

    @Override
    public Location findLocation(Integer locationId) {
        return accountRepository.findLocation(locationId);
    }

    @Override
    public Job findJob(Integer jobId) {
        return accountRepository.findJob(jobId);
    }
    public void updateAccount(Account account) {
        accountRepository.EditAccount(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


}
