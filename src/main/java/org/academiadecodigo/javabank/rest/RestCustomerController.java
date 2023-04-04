package org.academiadecodigo.javabank.rest;

import org.academiadecodigo.javabank.command.AccountDto;
import org.academiadecodigo.javabank.command.CustomerDto;
import org.academiadecodigo.javabank.converters.AccountToAccountDto;
import org.academiadecodigo.javabank.converters.CustomerToCustomerDto;
import org.academiadecodigo.javabank.exceptions.AccountNotFoundException;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestCustomerController {
    private CustomerService customerService;
    private AccountService accountService;
    private CustomerToCustomerDto customerToCustomerDto;
    private AccountToAccountDto accountToAccountDto;

    @Autowired
    public void setAccountToAccountDto(AccountToAccountDto accountToAccountDto) {
        this.accountToAccountDto = accountToAccountDto;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "api/customer",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<CustomerDto> listCustomer() {

        return customerToCustomerDto.convert(customerService.list());

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "api/customer/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerDto getCustomer(@PathVariable Integer id) {

        return customerToCustomerDto.convert(customerService.get(id));

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "api/customer/{id}/account",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<AccountDto> getAccounts(@PathVariable Integer id) {

        return accountToAccountDto.convert(customerService.get(id).getAccounts());

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "api/customer/{id}/account/{aid}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public AccountDto getAccountInf(@PathVariable Integer id, @PathVariable Integer aid) {

        if (customerService.get(id).getAccounts().stream().anyMatch(account -> account.getId() == aid)){
            return accountToAccountDto.convert(accountService.get(aid));
        }
        else {
            throw new AccountNotFoundException();
        }
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "api/customer",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CustomerDto addCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Joao");
        customer.setLastName("Palma");
        customer.setEmail("mail@gmail.com");
        customer.setPhone("999777555");

        return customerToCustomerDto.convert(customerService.save(customer));
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "api/customer/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity editCustomer(@PathVariable Integer id) {
        Customer customer = customerService.get(id);
        customer.setFirstName("Carlos");
        customerService.save(customer);

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "api/customer/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {

        customerService.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
