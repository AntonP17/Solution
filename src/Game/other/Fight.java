package Game.other;

import Game.Character;
import Game.Classes.Mage;
import Game.Classes.Rogue;
import Game.Classes.Warrior;
import Game.enemy.Enemy;
import Game.weapons.Axe;
import Game.weapons.Sword;
import Game.weapons.Weapon;

import java.util.Random;
import java.util.Scanner;

public class Fight {

public static void calculateDamage(Character character, Enemy enemy) {
    Random random = new Random();

    while (true) {

        Scanner console = new Scanner(System.in);
        int randomDamageCharacter = random.nextInt(character.attack());

        enemy.reductHealth(randomDamageCharacter);

        System.out.println(character.getName() + " атакует " + enemy.getName() + " и наносит " + randomDamageCharacter + " урона.");
        System.out.println(character.getName() + " здоровье: " + character.getHealth() + ", " +
                enemy.getName() + " здоровье: " + enemy.getHealth());
        System.out.println();


        if (enemy.getHealth() <= 0){
            System.out.println((character.getName() + "получено опыта " + enemy.getExp() +  " уровень " +  character.levelUp(enemy.getExp())));
            int randomNumber = random.nextInt(4);

            switch (randomNumber) {
                case 0 -> {
                    if (character instanceof Warrior) {
                        Sword newSword = Sword.getSwordByEmeny();
                        character.equiWeapon(newSword);
                        System.out.println(character.getName() + " получил " + newSword.getName());
                    } else if (character instanceof Mage) {
                        System.out.println("посох для мага");
                    } else if (character instanceof Rogue) {
                        System.out.println("оружие для роги");
                    }

                }
                case 1 -> {
                    if (character instanceof Warrior){
                        Axe newAxe = Axe.getAxeByEmeny();
                        character.equiWeapon(newAxe);
                        System.out.println(character.getName() + " получил " + newAxe.getName());
                    } else if (character instanceof Mage) {
                       System.out.println("посох для мага");
                    } else if (character instanceof Rogue) {
                    System.out.println("оружие для роги");
                    }

                }
                case 2 -> {
                    if (character instanceof Warrior){
                        System.out.println("оружие для воина");
                    } else if (character instanceof Mage) {
                        System.out.println("посох для мага");
                    } else if (character instanceof Rogue) {
                        System.out.println("оружие для роги");
                    }
                }


                case 3 -> System.out.println("Nothing");
            }

            break;
        }

        int randomDamageEnemy = random.nextInt(enemy.attack());

        character.reductHealth(randomDamageEnemy);

        System.out.println(enemy.getName() + " атакует " + character.getName() + " и наносит " + randomDamageEnemy + " урона.");
        System.out.println(enemy.getName() + " здоровье: " + enemy.getHealth() + ", " +
                character.getName() + " здоровье: " + character.getHealth());
        System.out.println();

        if (character.getHealth() == 0){
            System.out.println((enemy.getName()));
            break;
        }

    }
}
}
