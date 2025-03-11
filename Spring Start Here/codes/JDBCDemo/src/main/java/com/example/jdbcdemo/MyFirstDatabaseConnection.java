package com.example.jdbcdemo;

import java.sql.*;

public class MyFirstDatabaseConnection {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:mem:testdb";
        try (
                Connection connection = DriverManager.getConnection(url, "sa", "");
                PreparedStatement ps = connection.prepareStatement("SELECT * FROM EXHIBITS");
                ResultSet rs = ps.executeQuery()) {
                while (rs.next())
                    System.out.println(rs.getString(1));
        }
    }
}
