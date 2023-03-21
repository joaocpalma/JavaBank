package org.academiadecodigo.javabank.MyTests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import java.util.ArrayList;

public class PokemonService {
    private EntityManagerFactory emf;

    public void add(Pokemon pokemon){

        EntityManager em = emf.createEntityManager();

        try {
        em.getTransaction().begin();

        em.persist(pokemon);

        em.getTransaction().commit();

    } catch (RollbackException exception){
        em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Pokemon findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(Pokemon.class, id); // always the primary key

        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
