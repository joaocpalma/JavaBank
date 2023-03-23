package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.AccountDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class JpaAccountDao implements AccountDao {

    @Override
    public Account remove(Integer id) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public List<Account> list() {
        return null;
    }

    @Override
    public Account find(Integer id) {
        return null;
    }

    @Override
    public Integer add(Account account) {
     return 0;
    }
}
