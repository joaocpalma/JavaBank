package org.academiadecodigo.javabank.mytests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;

public class TrainerService {
    private EntityManagerFactory emf;

    public void add(Trainer trainer){

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(trainer);

            em.getTransaction().commit();

        } catch (RollbackException exception){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
}

