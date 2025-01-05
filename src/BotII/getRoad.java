package BotII;

import java.util.Scanner;

public class getRoad {
    public void roadMethod(){
        Scanner console = new Scanner(System.in);

        System.out.println("Напишите город, в котором вы хотите узнат ситуацию на дорогах, либо \"Exit\" чтобы выйти в главное меню");
        String town = console.nextLine();

        switch (town) {
            case "Москва":
                System.out.println("на дорогах много пафоса");
                getRoad n = new getRoad();
                n.roadMethod();
                break;
            case "Санкт-Петербург":
                System.out.println("на дороге все вежливые");
                getRoad spb = new getRoad();
                spb.roadMethod();
                break;
            case "Казань":
                System.out.println("сюда лучше не соваться:-)");
                getRoad kazan = new getRoad();
                kazan.roadMethod();
                break;
            case "Exit":
                Start exit = new Start();
                exit.startMethod();
                break;
            default:
                System.out.println("Такого города нет в моей базе:(");
        }
    }
}
