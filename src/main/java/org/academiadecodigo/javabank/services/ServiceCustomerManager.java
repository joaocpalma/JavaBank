package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ServiceCustomerManager implements CustomerService{

    HashMap<Integer, Customer> customers = new HashMap<>();

    public HashMap<Integer, Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer get(Integer id) {
        return customers.get(customers.keySet());
    }

    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        return customers.keySet();
    }

    @Override
    public double getBalance(int customerId) {
        return 0;
    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
