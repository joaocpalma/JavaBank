package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.jdbc.ConnectionManager;
import org.academiadecodigo.javabank.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JdbcCustomerService implements CustomerService{
    ResultSet resultSet;
    Customer customer;
    private Connection dbConnection;

    public JdbcCustomerService(Connection dbConnection){
        this.dbConnection = dbConnection;
    }

    ArrayList<String> customerValues = new ArrayList<>();

    public ArrayList<String> getCustomerValues() {
        return customerValues;
    }

    @Override
    public Customer get(Integer id) {

        customer = new Customer();
        try {

        Statement statement = dbConnection.createStatement();

        String query = "SELECT * FROM customer WHERE id="+id;
        resultSet = statement.executeQuery(query);

        // user exists
        if(resultSet.next()) {

            String customerFirstName = resultSet.getString("first_name");
            String customerLastName = resultSet.getString("last_name");
            String customerEmail = resultSet.getString("email");
            String customerPhone = resultSet.getString("phone");

            customer.setFirst_name(customerFirstName);
            customer.setLast_name(customerLastName);
            customer.setEmail(customerEmail);
            customer.setPhone(customerPhone);

            customerValues.add(customerFirstName);
            customerValues.add(customerLastName);
            customerValues.add(customerEmail);
            customerValues.add(customerPhone);

            System.out.println(customerValues);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return null;
    }

    @Override
    public double getBalance(int id) {
        double balance = 0;
        customer = new Customer();

        try {

            Statement statement = dbConnection.createStatement();

            String query = "SELECT * FROM account WHERE id="+id;
            resultSet = statement.executeQuery(query);

            // user exists
            if(resultSet.next()) {

                double customerBalance = resultSet.getDouble("balance");

                customer.setBalance(customerBalance);

                balance = customerBalance;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(balance);
        return balance;
    }

    @Override
    public void add(Customer customer) {

    }
}