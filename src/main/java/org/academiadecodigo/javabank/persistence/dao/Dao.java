package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;

public interface Dao<T> {

    void remove(Integer id);

    void update(T t);

    T list();

    T find(Integer id);

    void add(T t);

}
