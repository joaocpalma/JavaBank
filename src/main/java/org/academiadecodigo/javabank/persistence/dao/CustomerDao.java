package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;

import java.util.List;

public interface CustomerDao {
    void remove(Integer id);

    void update(Customer customer);

    List<Customer> list();

    Customer find(Integer id);

    void add(Customer customer);
}
