package org.example.sqch15ex1.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Account {

    @Id
    private int id;
    private String name;
    private BigDecimal amount;

    public Account() {}

    public Account(int id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
