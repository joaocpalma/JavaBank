package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.jdbc.ConnectionManager;
import org.academiadecodigo.javabank.services.JdbcCustomerService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.getConnection();

        Connection connection = connectionManager.getConnection();

        JdbcCustomerService jdbcCustomerService = new JdbcCustomerService(connection);
        jdbcCustomerService.count();
        jdbcCustomerService.get(2);
        jdbcCustomerService.getBalance(2);
    }
}
