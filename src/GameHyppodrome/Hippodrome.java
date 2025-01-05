package GameHyppodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List list){
        this.horses = list;
    }


    public Horse getWinner(){
        Horse result = horses.get(0);
        for (Horse horse : horses){
            if (horse.getDistance() > result.getDistance()){
                result = horse;
            }
        }
        return result;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public List<Horse> getHorses(){
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++){
            move();
            print();
            Thread.sleep(200);

        }
    }

    public void move(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).move();
        }
    }

    public void print(){
        for (int i = 0; i < horses.size(); i++){
            horses.get(i).print();
        }

        for (int i = 0 ; i < 10; i++){
            System.out.println();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Zorka", 3, 0));
        horses.add(new Horse("Mirka", 3, 0));
        horses.add(new Horse("Milena", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}
