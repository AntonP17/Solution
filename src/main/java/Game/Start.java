package Game;

import Game.Classes.Mage;
import Game.Classes.Rogue;
import Game.Classes.Warrior;
import Game.enemy.Cobold;
import Game.enemy.Enemy;
import Game.other.Fight;
import Game.weapons.Sword;
import Game.weapons.Weapon;

import java.util.Random;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        Character character = characterSelection();
        if (character != null){
            fight(character);
        }

    }

    public static Character characterSelection(){
        Scanner console = new Scanner(System.in);
        System.out.println("Выбери своего бойца 1- воин, 2 - маг, 3 - разбойник ");
        int characterSelection = console.nextInt();
        console.nextLine();
        System.out.println("Введите имя ");
        String name = console.nextLine();

        Character character = null;

        switch (characterSelection){
            case 1 -> {
                character = new Warrior(name);
                System.out.println("персонаж воин создан " + character.getName());
            }
            case  2 -> {
                character = new Mage(name);
                System.out.println("персонаж маг создан " + character.getName());
            }
            case 3 -> {
                character = new Rogue(name);
                System.out.println("персонаж разбойник создан ");
            }
        }
        return character;
    }


    public static void fight(Character character){

        Enemy cobold = new Cobold();
        System.out.println("враг создан " + cobold.getName());
        System.out.println();

        Fight.calculateDamage(character,cobold);
    }


}
