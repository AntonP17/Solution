package Test;

import java.util.ArrayList;

public class InterfaceExample {

    public static ArrayList<Runnable> list = new ArrayList<>();

    public static void main(String[] args) {

        addToList(new Car());
        addToList(new Plane());

        runList();

    }

    public static void addToList(Runnable runnable) {

          list.add(runnable);

    }

    public static void runList() {

        for(Runnable element : list){
            element.run();
        }

    }
}

 interface Runnable {
    void run();
}

class Car implements Runnable {

    @Override
    public void run() {
        System.out.println("Car is running!");
    }
}

class Plane implements Runnable {

    @Override
    public void run() {
        System.out.println("Plane is running!");
    }
}






