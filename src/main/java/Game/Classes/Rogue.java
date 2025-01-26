package Game.Classes;

import Game.Character;

public class Rogue extends Character {

    public Rogue(String name){
        super(name,1,87,20,33,67);
    }

    @Override
    public int attack() {
        return ability;
    }
}
