package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.model.account.AccountType;
import org.academiadecodigo.javabank.persistence.ConnectionManager;
import org.academiadecodigo.javabank.services.AccountService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JpaAccountService implements AccountService {
    private EntityManagerFactory emf;
    private AccountFactory accountFactory;
    public JpaAccountService(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
    public JpaAccountService(){}

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Account get(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();

            CriteriaQuery<Account> customerCriteriaQuery = builder.createQuery(Account.class);

            Root<Account> root = customerCriteriaQuery.from(Account.class);

            customerCriteriaQuery.select(root);

            customerCriteriaQuery.where(builder.equal(root.get("id"), id));

            return em.createQuery(customerCriteriaQuery).getSingleResult();
        } finally {
            if (em != null){
                em.close();
            }
        }

    }

    @Override
    public void deposit(int id, double amount) {

    }

    @Override
    public void withdraw(int id, double amount) {


    }

    @Override
    public void transfer(int srcId, int dstId, double amount) {

    }

    private void updateBalance(int id, double totalBalance) throws SQLException {

    }


    @Override
    public void add(Account account) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();

        } catch (RollbackException exception){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
