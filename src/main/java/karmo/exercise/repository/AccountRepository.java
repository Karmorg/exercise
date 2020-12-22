package karmo.exercise.repository;

import karmo.exercise.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(Account account) {
        String sql = "INSERT INTO account (name, currency, balance, treasury) " +
                "VALUES (:name, :currency, :balance, :treasury)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", account.getName());
        paramMap.put("currency", account.getCurrency().toString());
        paramMap.put("balance", account.getBalance());
        paramMap.put("treasury", account.getTreasury());
        jdbcTemplate.update(sql, paramMap);
    }

    public List<String> accountNames() {
        String sql = "SELECT name FROM account";
        Map<String, Object> paramMap= new HashMap<>();
        return jdbcTemplate.queryForList(sql, paramMap, String.class);
    }

    public BigDecimal getBalance(String aName) {
        String sql = "SELECT balance FROM account WHERE name= :aName";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("aName", aName);
        return jdbcTemplate.queryForObject(sql, paramMap, BigDecimal.class);
    }

    public boolean isTreasury(String aName) {
        String sql = "SELECT treasury FROM account WHERE name= :aName";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("aName", aName);
        return jdbcTemplate.queryForObject(sql, paramMap, boolean.class);
    }

    public void updateBalance(BigDecimal newAmount, String name) {
        String sql = "UPDATE account SET balance= :newBalance WHERE name= :name";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        paramMap.put("newBalance", newAmount);
        jdbcTemplate.update(sql, paramMap);
    }

    public String getCurrency(String name) {
        String sql = "SELECT currency FROM account WHERE name= :name";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
}


