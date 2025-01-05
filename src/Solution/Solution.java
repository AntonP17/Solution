package Solution;

import java.util.Scanner;

import java.util.Random;

public class Solution {

    public static void main(String[] args) {

        System.out.println("Введите ниже ваш вопрос : ");
        Scanner console = new Scanner(System.in);
        String question = console.nextLine();

        System.out.println(question);
        System.out.println(MagicBall.getPrediction());
    }
}











