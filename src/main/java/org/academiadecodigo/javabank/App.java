package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.factories.AccountFactory;
import org.academiadecodigo.javabank.persistence.ConnectionManager;
import org.academiadecodigo.javabank.services.jdbc.JdbcAccountService;
import org.academiadecodigo.javabank.services.jdbc.JdbcCustomerService;
import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.services.jpa.JpaAccountService;
import org.academiadecodigo.javabank.services.jpa.JpaCustomerService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {



        App app = new App();
        app.bootStrap();
    }

    private void bootStrap() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        ConnectionManager connectionManager = new ConnectionManager();

        AccountFactory accountFactory = new AccountFactory();
        JpaAccountService accountService = new JpaAccountService(accountFactory);
        JpaCustomerService customerService = new JpaCustomerService(accountService);
        customerService.setEmf(emf);

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(accountService);
        bootstrap.setCustomerService(customerService);
        bootstrap.setAccountFactory(accountFactory);
        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

        connectionManager.close();

        JpaAccountService jpaAccountService = new JpaAccountService();

        jpaAccountService.get(1);
    }
}
