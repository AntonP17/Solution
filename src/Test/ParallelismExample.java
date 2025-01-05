package Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelismExample {
    public static void main(String[] args) throws InterruptedException {

        final int MAX = 64; // значение которое будем делить между потоками , это имитация нужной задачи
        ForkJoinPool pool = new ForkJoinPool(16); // создается пул с потоками для параллельных задач , в конструкторе мы указали число потоков 16 и они как раз будут делить нашу задачу
        pool.invoke(new MyAction(MAX)); // тут понятно что invоke() передает нашу задачу (число MAX) чтобы потоки начали ее выполнять, еще он блокирует поток Main пока задачи не завершатся
        System.out.println("FINISH");

    }

}

// RecursiveAction это класс который позволяет разделять одну задачу на более маленькие поэтому мы екстендимся от него
class MyAction extends RecursiveAction {

    private int value;

    public MyAction(int value) {
        this.value = value;
    }

    // и как раз в этом методе начинается наше параллельное выполнение одной задачи
    @Override
    protected void compute() {
        if (value <= 4){ // если задача малельная (в данном примере если меньше 4) то она выполняется без разделения
            System.out.println("Hello before " + Thread.currentThread().getId() + " " + value);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.getMessage();
            }
            System.out.println("Hello after " + Thread.currentThread().getId() + " " + value);
        } else { // иначе делится на 2 подзадачи
            MyAction m1 = new MyAction(value / 2); // подзадача 1 которая деит основную на 2
            MyAction m2 = new MyAction(value / 2); // 2 подзадача которая делит тое
            invokeAll(m1, m2); // запускает их и ждет завершения
        }
    }
}
