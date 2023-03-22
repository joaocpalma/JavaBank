package org.academiadecodigo.javabank.mytests;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Small Pokeralho")
public class BabyPokemon extends Pokemon{

    public void beCute(){
        System.out.println("|O...O|");
    }
}
