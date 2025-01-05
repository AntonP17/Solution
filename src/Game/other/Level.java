package Game.other;

import java.util.HashMap;
import java.util.Map;

public class Level {

private static final HashMap<Integer,Integer> expToLvlup = new HashMap<>();

     static {
      expToLvlup.put(1, 100);
      expToLvlup.put(2, 200);
      expToLvlup.put(3, 300);
      expToLvlup.put(4, 400);
     }

    public static int getExpTolvlup(int currentlvl ){
        return expToLvlup.getOrDefault(currentlvl, 0);
    }

}
