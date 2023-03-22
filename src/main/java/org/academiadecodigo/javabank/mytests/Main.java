package org.academiadecodigo.javabank.mytests;

import org.academiadecodigo.javabank.services.jpa.JpaAccountService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
/*
        PokemonService service = new PokemonService();
        TrainerService trainerService = new TrainerService();
        service.setEmf(emf);
        trainerService.setEmf(emf);

        *//* Pokemon p1 = new Pokemon("Electric","Pikachu","Yellow Rat");
        Pokemon p2 = new Pokemon("Water","Squirtle","Wet_squirel");
        Pokemon p3 = new Pokemon("Grass","Bulbassur","Turnip");

        p1.setMoveSet(new MoveSet("Volt Tackle","Electroweb","Electro Ball","Iron Tail"));
        p2.setMoveSet(new MoveSet("Bubble Beam","Hydro Pump","Rapid Spin","Withdraw"));
        p3.setMoveSet(new MoveSet("Seed Bomb","Sludge Bomb","Power Whip","Frustration Shadow"));*//*

        Pokemon p1 = new BabyPokemon();
        p1.setNickname("zé");
        p1.setType("electric");
        p1.setOfficial_name("Pikachu");

        Pokemon p2 = new NormalPokemon();
        p2.setNickname("samz");
        p2.setType("rock");
        p2.setOfficial_name("pokeram");

        Trainer ash = new Trainer(19,"Ash","Pikachu");

        trainerService.add(ash);
        service.add(p1);
        service.add(p2);
        
        emf.close();*/

        /*JpaAccountService jpaAccountService = new JpaAccountService();

        jpaAccountService.get(1);
*/
    }
}
