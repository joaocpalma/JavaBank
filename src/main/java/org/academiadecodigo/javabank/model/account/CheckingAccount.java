package org.academiadecodigo.javabank.model.account;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * A checking account with no restrictions
 * @see Account
 * @see AccountType#CHECKING
 */
@Entity
@DiscriminatorValue("checkings")
public class CheckingAccount extends AbstractAccount {

    /**
     * @see Account#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }
}
