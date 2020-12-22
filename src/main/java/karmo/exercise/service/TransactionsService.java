package karmo.exercise.service;

import karmo.exercise.Transfer;
import karmo.exercise.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class TransactionsService {

    @Autowired
    private AccountRepository accountRepository;


    public String transferMoney(Transfer transfer) {

        List<String> existingAccounts = accountRepository.accountNames();

        if (existingAccounts.contains(transfer.getFromName()) && existingAccounts.contains(transfer.getToName())){

            if (currenciesMatch(transfer.getFromName(), transfer.getToName())){

                if (withdraw(transfer.getFromName(), transfer.gettAmount()).equals("Done")){
                    deposit(transfer.getToName(), transfer.gettAmount());
                    return "Done";
                } else {
                    return "Not enough resources on the account.";
                }
            }else {
                return "Currencies don't match";
            }
        } else {
            return "Either of the accounts isn't registered.";
        }
    }

    private boolean currenciesMatch(String fromName, String toName) {
        return accountRepository.getCurrency(fromName).equals(accountRepository.getCurrency(toName));
    }

    public String withdraw (String name, BigDecimal amount){
        amount = amount.abs();
        BigDecimal oldBalance = accountRepository.getBalance(name);
        if (oldBalance.compareTo(amount) > 0 ||
                accountRepository.isTreasury(name)){
            accountRepository.updateBalance(oldBalance.subtract(amount), name);
            return "Done";

        } else {
            return "Not enough resources on the account.";
        }
    }

    private void deposit(String toName, BigDecimal tAmount) {
        tAmount = tAmount.abs();
        BigDecimal oldBalance = accountRepository.getBalance(toName);
        accountRepository.updateBalance(oldBalance.add(tAmount), toName);
    }
}
