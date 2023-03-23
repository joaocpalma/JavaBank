package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.persistence.jpa.JpaSessionManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JpaCustomerDao implements CustomerDao {
    JpaSessionManager jpaSessionManager;


    @Override
    public void remove(Integer id) {
        EntityManager em = jpaSessionManager.getCurrentSession();
        em.remove(id);
        System.out.println(id + " removed");
    }

    @Override
    public void update(Customer customer) {
        EntityManager em = jpaSessionManager.getCurrentSession();
        em.merge(customer);
    }

    @Override
    public List<Customer> list() {

        EntityManager em = jpaSessionManager.getCurrentSession();

        TypedQuery<Customer> query =
                em.createQuery("SELECT customer FROM Customer customer", Customer.class);

        return query.getResultList();
    }

    @Override
    public Customer find(Integer id) {
        EntityManager em = jpaSessionManager.getCurrentSession();
            return em.find(Customer.class, id);

    }

    @Override
    public void add(Customer customer) {
        update(customer);
    }
}
