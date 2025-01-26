package Game.weapons;

import java.util.ArrayList;
import java.util.Random;

public class Sword extends Weapon{

    public Sword(String name , int damage) {
        super(name, damage);
    }

    private static final ArrayList<Sword> swordList = new ArrayList<>();
    static {
        swordList.add(new Sword("Shadowmorn", 20));
        swordList.add(new Sword("Sword of Fire", 120));
        swordList.add(new Sword("Sword of Frost", 220));
    }

    public static Sword getSwordByEmeny() {
        Random random = new Random();
        int randomIndex = random.nextInt(swordList.size());
        Sword randomSword = swordList.get(randomIndex);
        return randomSword;
    }


}
