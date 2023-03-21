package org.academiadecodigo.javabank.MyTests;

import javax.persistence.*;


@Entity
@Table(name = "trainers")
public class Trainer extends AbstractionModel {

    private Integer age;
    private String name;
    private String favPokemon;

    public Trainer(Integer age, String name, String favPokemon) {
        this.age = age;
        this.name = name;
        this.favPokemon = favPokemon;
    }

    public Trainer() {}

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavPokemon() {
        return favPokemon;
    }

    public void setFavPokemon(String favPokemon) {
        this.favPokemon = favPokemon;
    }
}
