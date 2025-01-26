package BotII;

import java.util.Scanner;

public class Start {
    public void startMethod(){
        Scanner console = new Scanner(System.in);
        String one = "1 - начать диалог";
        String two = "2 - спросить погоду";
        String three = "3 - спросить о ситуации на дороге";
        String four = "4 - завершить программу";
        System.out.println(one + "\n" + two + "\n" + three + "\n" + four);
        int number = console.nextInt();

        if (number == 1) {
            getName n = new getName();
            n.nameMethod();
        }
        if (number == 2) {
            getWeather n = new getWeather();
            n.weatherMethod();
        }

        if (number == 3) {
            getRoad n = new getRoad();
            n.roadMethod();
        }
        if (number == 4) {
            test n = new test();
            System.out.println(n.EXIT);
        }
    }
}
