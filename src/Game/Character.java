package Game;

import Game.other.Level;
import Game.other.Skills;
import Game.weapons.Weapon;

public abstract class Character implements Skills {

    protected String name;
    protected int level;
    protected int health;
    protected int intellect;
    protected int strength;
    protected int ability;
    private Weapon weapon;

    public Character(String name, int level, int health, int intellect, int strength, int ability) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.intellect = intellect;
        this.strength = strength;
        this.ability = ability;
    }

    public void equiWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public Weapon getWeapon(){
        return weapon;
    }

    public int attack(){
        if (weapon != null){
            return strength + weapon.getDamage();
        } else {
            return strength;
        }
    }

    public String getName() {
        return name;
    }


    // получение урона
    public void reductHealth(int damage){
        health -= damage;
        if (health < 0){
            health = 0;
        }
    }

    // повышение уровня
    public int levelUp(int exp) {

        int needExp = Level.getExpTolvlup(level);

        if (exp >= needExp) {
            level += 1;
            health += 40;
            intellect += 20;
            strength += 30;
            ability += 20;
        }
        return level;
    }


    public int defend() {
        return 0;
    }



    public int getLevel (){
            return level;
        }


        public int getHealth (){
        return health;
        }


        public int getIntelect (){
        return intellect;
        }


        public int getability (){
        return ability;
        }

        public int getAbility() {
        return ability;
        }

        public int getStrength(){
        return strength;
        }



}
