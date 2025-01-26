package BotII;

import java.io.InputStream;
import java.util.Scanner;

public class getWeather {
    public void weatherMethod(){
        Scanner console = new Scanner(System.in);


        System.out.println("Напишите город, в котором хотите узнать погоду либо \"Exit\" чтобы выйти в главное меню");
        String town = console.nextLine();

        switch (town) {
            case "Москва":
                System.out.println("В Москве сейчас солнечно , температура воздуха составляет 20 градусов." + "\n");
                getWeather n = new getWeather();
                n.weatherMethod();
                break;
            case "Санкт-Петербург":
                System.out.println("В Санкт-Петербурге сейчас пасмурно , небольшой дождь , температура воздуха составляет 18 градусов.");
                getWeather m = new getWeather();
                m.weatherMethod();
                break;
            case "Казань":
                System.out.println("В Казани сейчас пасмурно , температура воздуха 22 градуса");
                getWeather q = new getWeather();
                q.weatherMethod();
                break;
            case "Exit":
                Start w = new Start();
                w.startMethod();
                break;
            default:
                System.out.println("Такого города нет в моей базе:(");
                getWeather mn = new getWeather();
                mn.weatherMethod();
                break;


        }
    }
}


