package org.academiadecodigo.javabank;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.javabank.domain.Bank;
import org.academiadecodigo.javabank.domain.Customer;
import org.academiadecodigo.javabank.domain.account.Account;
import org.academiadecodigo.javabank.domain.account.AccountType;
import org.academiadecodigo.javabank.managers.AccountManager;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        boolean isClient = false;
        AccountManager accountManager = new AccountManager();

        Bank bank = new Bank(accountManager);

        Customer joao = new Customer(1,"João",accountManager,bank);
        Customer daniel = new Customer(2,"Daniel",accountManager,bank);

        joao.openAccount(AccountType.SAVINGS, joao.getId());
        daniel.openAccount(AccountType.SAVINGS, daniel.getId());

        for (Customer customer: bank.getCustomers()) {
            System.out.println(customer);
        }

        for (Integer customer: accountManager.getAccountMap().keySet()) {
            System.out.println(customer);
        }

        IntegerInputScanner askForId = new IntegerInputScanner();

        boolean online = true;

        String[] menuOptions = {
                "View Balance",
                "Make Deposit",
                "Make Withdraw",
                "Open account",
                "Quit"
        };
        MenuInputScanner menuInputScanner = new MenuInputScanner(menuOptions);

        String[] openAccOptions = {
                "CheckingAccount",
                "SavingsAccount"
        };
        MenuInputScanner openAccMenu = new MenuInputScanner(openAccOptions);

        while (online) {

            Prompt prompt = new Prompt(System.in, System.out);

            askForId.setMessage("Please insert you ID number \n");

            int idAnswer = prompt.getUserInput(askForId);

                for (Integer customerId : accountManager.getAccountMap().keySet()) {
                    if (customerId == idAnswer ) {
                        menuInputScanner.setMessage("Welcome to JavaBank" + );
                        int menuAnswer = prompt.getUserInput(menuInputScanner);

                        if (menuAnswer == 1){

                        } else if (menuAnswer == 2){

                        } else if (menuAnswer == 3) {

                        } else if (menuAnswer == 4) {
                            openAccMenu.setMessage("Select a account type you would like to open");
                            int openAccAnswer = prompt.getUserInput(openAccMenu);

                            if (openAccAnswer == 1) {

                            } else if (openAccAnswer == 2) {

                            }
                        } else if (menuAnswer == 5) {
                            online = false;
                        }

                    }
                    }
        }
    }
}
