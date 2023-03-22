package org.academiadecodigo.javabank.services.jpa;

import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.model.account.AbstractAccount;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.TransactionManager;
import org.academiadecodigo.javabank.persistence.dao.CustomerDao;
import org.academiadecodigo.javabank.services.CustomerService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A JPA {@link CustomerService} implementation
 */
public class JpaCustomerService implements CustomerService {

    private TransactionManager tm;
    private CustomerDao customerDao;

    @Override
    public Customer get(Integer id) {
        tm.beginRead();
        Customer c = customerDao.find(id);
        tm.commit();
        return c;
    }

    /**
     * @see CustomerService#getBalance(Integer)
     */
    @Override
    public double getBalance(Integer id) {
        tm.beginRead();

            Customer customer = Optional.ofNullable(customerDao.find(id)).orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

            double total = 0;
            for (Account account : customer.getAccounts()) {
                total += account.getBalance();
            }
            tm.commit();
            return total;

    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {
        tm.beginRead();

        Customer customer = Optional.ofNullable(customerDao.find(id))
                .orElseThrow(() -> new IllegalArgumentException("Customer does not exist"));

        tm.commit();
        return customer.getAccounts().stream()
                .map(Model::getId)
                .collect(Collectors.toSet());
    }
}
