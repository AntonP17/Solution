package Game.weapons;

import java.util.ArrayList;
import java.util.Random;

public class Axe extends Weapon{

    public Axe(String name , int damage) {
        super(name, damage);
    }

    private static final ArrayList<Axe> axeList = new ArrayList<>();
    static {
        axeList.add(new Axe("Axe of Strength", 20));
        axeList.add(new Axe("Demon Killer", 120));
        axeList.add(new Axe("Light of Sun", 120));
    }

    public static Axe getAxeByEmeny() {
        Random random = new Random();
        int randomIndex = random.nextInt(axeList.size());
        Axe randomAxe = axeList.get(randomIndex);
        return randomAxe;
    }


}
