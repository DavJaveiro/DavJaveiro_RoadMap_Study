package org.example.sqch12ex1.repository;

import org.example.sqch12ex1.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTempalte) { // constructor injection to get a instance JdbcTemplate
        this.jdbcTemplate = jdbcTempalte;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT into purchase (product, price) VALUES (?, ?)"; // null pq é chave primária

        /*O method update é um dos métodos fornecidos pela classe JbcTempalte para executar
        * consultas que alteram os dados no banco de dados*/
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
