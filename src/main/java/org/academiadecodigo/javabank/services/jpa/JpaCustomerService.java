package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.mytests.Pokemon;
import org.academiadecodigo.javabank.persistence.ConnectionManager;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.List;
import java.util.Set;

public class JpaCustomerService implements CustomerService {

    private AccountService accountService;
    private EntityManagerFactory emf;

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public JpaCustomerService(AccountService accountService) {
        this.accountService = accountService;

    }

    @Override
    public Customer get(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Customer.class, id); // always the primary key

        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
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
        return 0;
    }

    @Override
    public void add(Customer customer) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();

        } catch (RollbackException exception){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
