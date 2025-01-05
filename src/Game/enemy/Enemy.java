package Game.enemy;

import Game.other.Skills;

public abstract class Enemy implements Skills {

    protected String name;
    protected int level;
    protected int health;
    protected int intellect;
    protected int strength;
    protected int  ability;
    protected int exp;

    public Enemy(String name, int level, int health, int intellect, int strength, int ability) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.intellect = intellect;
        this.strength = strength;
        this.ability = ability;
    }

    public int getExp(){
        return exp;
    }

    @Override
    public void reductHealth(int damage) {
        health -= damage;
        if (health < 0){
            health = 0;
        }
    }

    @Override
    public int levelUp(int exp) {
        return 0;
    }

    @Override
    public int attack() {
        return strength;
    }

    @Override
    public int defend() {
        return 0;
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public int getLevel(){
        return level;
    }

    public int getStrength(){
        return strength;
    }

    public int getAbility(){
        return ability;
    }

    public int getIntellect(){
        return intellect;
    }

}
