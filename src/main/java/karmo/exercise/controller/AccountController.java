package karmo.exercise.controller;

import karmo.exercise.Account;
import karmo.exercise.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @PostMapping ("public/accounts")
    public void createAccount (@RequestBody Account account){
        accountService.createAccount(account);
    }

    @CrossOrigin
    @GetMapping ("restricted/accounts/{name}")
    public boolean accountExists (@PathVariable ("name") String aName ){
        return accountService.accountExists(aName);
    }

}
