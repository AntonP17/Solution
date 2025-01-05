package Game.Classes;

import Game.Character;
import Game.other.Level;
import Game.other.Skills;
import Game.weapons.Weapon;

public class Warrior extends Character {



    public Warrior (String name) {

        super(name, 1, 100, 10, 60, 30);
    }

    // мощный удар
    public static void skill1(){
        System.out.println("method is realize1");
    }

    // удар с разворота
    public static void skill2(){
        System.out.println("method is realize2");
    }

}
