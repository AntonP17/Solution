package Test;

// интерфейс для всех транспортных средств
public interface Vehicle {

    default void start(){
        System.out.println("Начинаю движение.");
    }

    void move();

    default void stop(){
        System.out.println("Останавливаюсь.");
    }
}

// класс Машина использует интерфейс для ТС
class Car2 implements Vehicle {


    public void move() {
        System.out.println("Еду со средней скоростью 70 км/ч.");
    }


}

// класс Автобус использует интерфейс для ТС
class Bus implements Vehicle{


    public void move() {
        System.out.println("Еду со средней скоростью 50 км/ч.");
    }


}

class Main{
    public static void main(String[] args) {
        Car2 car = new Car2();
        Bus bus = new Bus();

        System.out.println("Машина : ");
        car.start();
        car.move();
        car.stop();
        System.out.println();

        System.out.println("Автобус : ");
        bus.start();
        bus.move();
        bus.stop();

    }
}
