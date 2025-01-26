package Test;

public class Polymorphism {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(min(1,2));
        System.out.println(min(1,2,3));
        System.out.println(min(1,2,3,4));
        System.out.println(min(1,2,3,4,5));

        System.out.println();

        System.out.println(max(1,2));
        System.out.println(max(1,2,3));
        System.out.println(max(1,2,3,4));
        System.out.println(max(1,2,3,4,5));

    }

    // пример полиморфизма в ООП , в одном классе есть методы с одинаковыми именами , но разные параметры => они укальные


    public static int min(int num1 , int num2){
        return Math.min(num1,num2);
    }

    public static int min(int num1 , int num2 , int num3){
        return Math.min(Math.min(num1,num2),num3);
    }

    public static int min(int num1, int num2 , int num3 , int num4){
        return Math.min(Math.min(num1,num2),Math.min(num3,num4));
    }

    public static int min(int num1 , int num2, int num3, int num4, int num5){
        return Math.min(Math.min(Math.min(num1,num2),Math.min(num3,num4)),num5);
    }

    public static int max(int num1 , int num2){
        return Math.max(num1,num2);
    }

    public static int max(int num1 , int num2 , int num3){
        return Math.max(Math.max(num1,num2),num3);
    }

    public static int max(int num1, int num2 , int num3 , int num4){
        return Math.max(Math.max(num1,num2),Math.max(num3,num4));
    }

    public static int max(int num1 , int num2, int num3, int num4, int num5){
        return Math.max(Math.max(Math.max(num1,num2),Math.max(num3,num4)),num5);
    }
}
