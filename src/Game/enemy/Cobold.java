package Game.enemy;

public class Cobold extends Enemy {

    public Cobold(){
        super("Кобольд воин", 1, 100,21,32,12);
    }

    @Override
    public int attack() {
        System.out.println("не трогай свечу!");
        return super.attack();
    }

    public int getExp(){
        return 200;
    }
}
