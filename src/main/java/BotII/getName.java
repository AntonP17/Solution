package BotII;

import java.util.Scanner;

public class getName {
    public void nameMethod() {
        System.out.println("\n" + "Запущен режим диалога, напишите любое сообщение ниже : ");
        Scanner console = new Scanner(System.in);
        while (true) {
            String input = console.nextLine();
            if (input.equalsIgnoreCase("Exit")) {
                Start n = new Start();
                n.startMethod();
                break;
            } else if (input.equalsIgnoreCase("Как дела?")) {
                System.out.println("хорошо");
            }
        }
    }
}
