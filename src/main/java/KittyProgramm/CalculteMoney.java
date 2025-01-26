package KittyProgramm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculteMoney implements ThingCalculate{

    // позиция без ошибки
    @Override
    public Result positionWithoutErrror(int thingsWithoutErrors) {

        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            try {
                answer1 = console.nextInt();
                console.nextLine();
            } catch (InputMismatchException e){
                System.out.println("ERROR : Введите целое число, а не буквы");
                console.nextLine();
            }
            if (answer1 > thingsWithoutErrors || answer1 < 0) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thingsWithoutErrors + " и не меньше 0");
            }

        } while (answer1 > thingsWithoutErrors || answer1 < 0 );

        double num1 = answer1 * 3.7;
        double num2 = (thingsWithoutErrors - answer1) * 3.2;

        return new Result(num1,num2);

    }


    // позиция с браком
    @Override
    public Result  positionError(int thingsErrors) {


        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            answer1 = console.nextInt();

            if (answer1 > thingsErrors) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thingsErrors);
            }

        } while (answer1 > thingsErrors);

        double num1 = answer1 * 6;
        double num2 = (thingsErrors - answer1) * 6;

        return new Result(num1,num2);


    }

    // каркас(ну вот эта херня железная)
    @Override
    public Result skeleton(int thingsSkeleton) {

        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            answer1 = console.nextInt();

            if (answer1 > thingsSkeleton) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thingsSkeleton);
            }

        } while (answer1 > thingsSkeleton);

        double num1 = answer1 * 10;
        double num2 = (thingsSkeleton - answer1) * 10;

        return new Result(num1,num2);

    }

    // переклеить этикетку
    @Override
    public Result changeEticet(int thinsEticets) {

        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            answer1 = console.nextInt();

            if (answer1 > thinsEticets) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thinsEticets);
            }

        } while (answer1 > thinsEticets);

        double num1 = answer1 * 9;
        double num2 = (thinsEticets - answer1) * 8;
        //return num1 + num2;
        return new Result(num1,num2);

    }

    // поменять упаковку
    @Override
    public Result changePackage(int thingsChangePackage) {

        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            answer1 = console.nextInt();

            if (answer1 > thingsChangePackage) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thingsChangePackage);
            }

        } while (answer1 > thingsChangePackage);

        double num1 = answer1 * 8;
        double num2 = (thingsChangePackage - answer1) * 8;

        return new Result(num1,num2);

    }

    // грязь пятна и тд
    @Override
    public Result dirty(int thingsDirty) {

        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            answer1 = console.nextInt();

            if (answer1 > thingsDirty) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thingsDirty);
            }

        } while (answer1 > thingsDirty);

        double num1 = answer1 * 7;
        double num2 = (thingsDirty - answer1) * 7;

        return new Result(num1,num2);

    }

    // нитки (типо если длинная над обрезать и тд хз короче)
    @Override
    public Result treds(int thingsTreds) {

        Scanner console = new Scanner(System.in);
        int answer1 = 0;

        do {

            System.out.println("Сколько комплектов?");
            answer1 = console.nextInt();

            if (answer1 > thingsTreds) { // Проверка на превышение
                System.out.println("ERROR: Введите число не большее, чем " + thingsTreds);
            }

        } while (answer1 > thingsTreds);

        double num1 = answer1 * 7;
        double num2 = (thingsTreds - answer1) * 7;

        return new Result(num1,num2);

    }
}



