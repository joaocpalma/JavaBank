package org.academiadecodigo.javabank.persistence;

public interface TransactionManager {

    void beginRead();

    void beginWrite();

    void commit();

    void rollBack();

}
