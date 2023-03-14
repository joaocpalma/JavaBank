package org.academiadecodigo.javabank.services;

import org.academiadecodigo.javabank.model.Customer;

public class AuthServiceManager implements AuthService{
    @Override
    public boolean authenticate(Integer id) {
        return false;
    }

    @Override
    public Customer getAccessingCustomer() {
        return null;
    }
}
