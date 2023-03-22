package org.academiadecodigo.javabank.mytests;

import javax.persistence.Embeddable;

@Embeddable
public class MoveSet {
    private String move1;
    private String move2;
    private String move3;
    private String move4;

    public MoveSet(String move1, String move2, String move3, String move4) {
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }

    public MoveSet(){}
}
