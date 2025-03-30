package org.example.sqch15ex1.repository;

import org.example.sqch15ex1.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query("SELECT * FROM account WHERE anme = :name")
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query("UPDATE account SET amount = :amount where id = :id")
    void changeAmount(int id, BigDecimal amount);

    @Query("SELECT * FROM account")
    List<Account> findAllAccounts();

}
