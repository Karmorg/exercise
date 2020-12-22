package karmo.exercise.repository;

import karmo.exercise.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

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
}


