package org.example.sqch13ex1.repository;

import org.example.sqch13ex1.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    /*We annotate the methods that define operations that change data with the @Modify annotation*/
    @Modifying
    @Query("UPDATE account SET amount = :amount where id = :id")
    void changeAmount(long id, BigDecimal amount);

    @Query("SELECT * FROM account")
    List<Account> findAlAccounts();

}
