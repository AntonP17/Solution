package KittyProgramm;

import java.io.IOException;
import java.util.Scanner;

public class test extends CalculteMoney implements Questions {
    public static void main(String[] args) {

        System.out.println("Добро пожаловать в кошачий бот");
        getEffective();
    }

    // метод обработки запросов и вывод результата
    public static void getEffective() {

        Scanner console = new Scanner(System.in);
        test question = new test();
        CalculteMoney calculator = new CalculteMoney();

        Result[] results = new Result[7];

        results[0] = calculator.positionWithoutErrror(askQuestion(question.question1()));
        results[1] = calculator.positionError(askQuestion(question.question2()));
        results[2] = calculator.skeleton(askQuestion(question.question3()));
        results[3] = calculator.changeEticet(askQuestion(question.question4()));
        results[4] = calculator.changePackage(askQuestion(question.question5()));
        results[5] = calculator.dirty(askQuestion(question.question6()));
        results[6] = calculator.treds(askQuestion(question.question7()));

        for (int i = 0; i < results.length; i++){
            System.out.println("комплект = " + results[i].num1 + " одиночные = " + results[i].num2);
            double sumResult = results[i].num1 + results[i].num2;
            switch (i){
                case 0 :
                    System.out.println("цена вещей без ошибок " + sumResult);
                    break;
                case 1:
                    System.out.println("цена вещей с браком = " + sumResult);
                    break;
                case 2:
                    System.out.println("цена вещей с проблемным каркасом = " + sumResult);
                    break;
                case 3:
                    System.out.println("цена вещей с с проблемной этикеткой = " + sumResult);
                    break;
                case 4:
                    System.out.println("цена вещей с проблемной упаковкой = " + sumResult);
                    break;
                case 5:
                    System.out.println("цена вещей с пятнами,грязью = " + sumResult);
                    break;
                case 6:
                    System.out.println("цена вещей с распущенными нитками = " + sumResult);
                    break;


            }

        }
        printResults(results);
    }

    private static int askQuestion(String question){
        Scanner console = new Scanner(System.in);
        System.out.println(question);
        return console.nextInt();
    }

    private static void printResults(Result[] results){
        double sum = 0;
        for (Result result : results){
            sum += result.num1 + result.num2;

        }
        System.out.println("Сумма всего : " + sum);

    }
}


