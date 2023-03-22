package org.academiadecodigo.javabank.persistence;

import javax.persistence.EntityManager;

public interface SessionManager {

    void startSession();

    EntityManager getCurrentSession();

    void stopSession();
}
