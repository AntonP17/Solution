package Auto.Machines;

import Auto.Auto;
import Auto.Movement;


public class SkodaKaroq extends Auto implements Movement {

    private int maxSpeed = 240;
    private int speed = 10;

    public SkodaKaroq(){
        setModel("Skoda Karoq");
        setYear(2020);
        setEngine("1.4 CZEA");
        setColor("Синий");
    }

    public void setBeginSpeed(int speed){
        this.speed = speed;
    }

    public int getSpeed(){
        return speed;
    }

    @Override
    public void on() {
        System.out.println("двигатель запущен");
    }

    @Override
    public  void start() {
        System.out.println("Начало движения");
    }

    @Override
    public void move() {

        System.out.println("текущая скорость" + speed + "км/час");
    }

    @Override
    public void stop() {
        System.out.println("остановка");
    }

    @Override
    public void off() {
        System.out.println("двигатель заглушен");
    }
}
