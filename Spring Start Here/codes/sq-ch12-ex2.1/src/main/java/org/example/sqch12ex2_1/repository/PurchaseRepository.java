package org.example.sqch12ex2_1.repository;

import org.example.sqch12ex2_1.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT into purchase (product, price) values (?, ?)";

        jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllProducts() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (resultSet, integer) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(resultSet.getInt("id"));
            rowObject.setProduct(resultSet.getString("product"));
            rowObject.setPrice(resultSet.getBigDecimal("price"));
            return rowObject;
        };

        return jdbcTemplate.query(sql, purchaseRowMapper);
    }
}
