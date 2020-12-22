package karmo.exercise;

import java.math.BigDecimal;
import java.util.Currency;

public class Account {

    private String name;
    private Currency currency;
    private BigDecimal balance;
    private Boolean treasury;

    public String getName() {
        return name;
    }

    public Account setName(String name) {
        this.name = name;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Account setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Account setBalance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public Boolean getTreasury() {
        return treasury;
    }

    public Account setTreasury(Boolean treasury) {
        this.treasury = treasury;
        return this;
    }
}
