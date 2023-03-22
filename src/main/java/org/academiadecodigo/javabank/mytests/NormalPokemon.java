package org.academiadecodigo.javabank.mytests;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Normal Pokeralho")
public class NormalPokemon extends Pokemon{

    private void beBoring(){
        System.out.println("|--..--|");
    }
}
