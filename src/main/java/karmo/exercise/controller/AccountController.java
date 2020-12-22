package karmo.exercise.controller;

import karmo.exercise.Account;
import karmo.exercise.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @PostMapping ("public/accounts")
    public void createAccount (@RequestBody Account account){
        accountService.createAccount(account);
    }

}
