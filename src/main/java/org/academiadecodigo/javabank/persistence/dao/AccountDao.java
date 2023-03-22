package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;

import java.util.List;

public interface AccountDao {
    Account remove(Integer id);

    Account update(Account account);

    List<Account> list();

    Account find(Integer id);

    Account add(Account account);
}
