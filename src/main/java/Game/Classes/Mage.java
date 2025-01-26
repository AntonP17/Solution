package Game.Classes;

import Game.Character;

public class Mage extends Character {
    public Mage(String name){
        super(name,1,80,89,45,32);
    }

    @Override
    public int attack() {
        return intellect;
    }
}
