package org.example.sqch13ex1.repository;

import org.example.sqch13ex1.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {


    @Override
    public Account mapRow(ResultSet resultSet, int rowNum) // int rowNum é o número da linha
        throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getLong("id"));
        account.setName(resultSet.getString("name"));
        account.setAmount(resultSet.getBigDecimal("amount"));
        return account;
    }

}
