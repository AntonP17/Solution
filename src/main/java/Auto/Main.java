package Auto;

import Auto.Machines.SkodaKaroq;
import Auto.Machines.ToyotaCamry;


import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {



        System.out.println("Добро пожаловать в наш салон по аренде автомобилей , введите свой запрос ниже (либо exit для выхода): ");
        String welcome = "1 - Доступные модели " + "\n"
                       + "2 - выбрать авто" + "\n"
                       + "3 - сдать автомобиль";
        System.out.println(welcome);
        Scanner console = new Scanner(System.in);

        while (true){

            String number = console.nextLine();
            if (number.equalsIgnoreCase("exit")){
                System.out.println("До свидания:)");
                break;
            } else if (number.equals("1")) {
                  showModels();
                  break;
            }

            }
        console.close();

    }

    public static void showModels(){

        Scanner console = new Scanner(System.in);

        /* СТарая версия кода
        SkodaKaroq car1 = new SkodaKaroq();
        System.out.println(car1.getModel());
        ToyotaCamry car2 = new ToyotaCamry();
        System.out.println(car2.getModel());*/

        ArrayList<Auto> cars = new ArrayList<>();
        cars.add(new SkodaKaroq());
        cars.add(new ToyotaCamry());
        for (Auto carsList : cars){
            System.out.println(carsList.getModel());
        }


        System.out.println("Какой автомобиль предпочитаете?");

       /* старая версия кода
       System.out.println("1 - " + carsList.getModel()); // Добавлено для ясности
        System.out.println("2 - " + car2.getModel()); // Добавлено для ясности*/

        String input = console.nextLine(); // Читаем ввод от пользователя

        if (input.equals("1")) {
            showDetalsOfAuto(cars.get(0)); // Передаем объект в showDetalsOfAuto
        } else if (input.equals("2")) {
            showDetalsOfAuto(cars.get(1)); // Передаем объект в showDetalsOfAuto
        } else {
            System.out.println("Неверный ввод");
        }
        console.close();

    }

    public static void showDetalsOfAuto(Auto car){

        Scanner console = new Scanner(System.in);

        System.out.println(car.getModel() + "\n" + car.getEngine() + "\n" + car.getYear() + "\n" + car.getColor());

        System.out.println("Выбрать данный авто или посмотреть другой?");
        System.out.println("1 - выбрать данный авто" + "\n"
        + "2 - выбрать другой");

        String input = console.nextLine();
        if(input.equals("1")){
            showMethodsOfAuto(car);
        }
        console.close();

    }

    public static void showMethodsOfAuto(Auto car){
        Scanner console = new Scanner(System.in);

        System.out.println("Доступные действия:");
        System.out.println("1 - Запустить двигатель");
        System.out.println("3 - Вернуться к выбору автомобиля");


        String input = console.nextLine();

        if (input.equals("1")) {
            car.on();
            showStartMoving( (SkodaKaroq) car);
        }

        console.close();

    }

    public static void showStartMoving(SkodaKaroq car){
            Scanner console = new Scanner(System.in);

            car.start();
            car.move();

            System.out.println("нажмите + для набора скорости или - для тормоза");
            String input = console.nextLine();
        if (input.equals("+")){
            car.gas();
            car.setBeginSpeed(60);
            car.move();
        }

    }




}



