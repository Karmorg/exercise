package karmo.exercise.service;

import karmo.exercise.Account;
import karmo.exercise.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void createAccount(Account account) {
        accountRepository.createAccount(account);
    }

    public boolean accountExists(String aName) {
        return accountRepository.accountNames().contains(aName);
    }
}
