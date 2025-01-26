package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newWorkStealingPool(); // создается пул потоков
        List<Callable<String>> tasks = new ArrayList<>(); // список задач на выполнение

        // имитация создания 10 задач
        for (int i = 0; i < 10; i++){
            MyCallable mc = new MyCallable();
            tasks.add(mc); // тут задача отправляется в наш пул для решения и возвращает реультат
            // если был бы метод execute() то пул потоков просто выполнит и все
        }
        List<Future<String>> results = es.invokeAll(tasks); // список заверешенных задач
        // тут еще можно поменять метод на invokeAny() тогда у нас завершитсч толлко одна задача

        es.shutdown(); // закрываем пул потоков чтобы он не принимал больше задачи
      //  es.awaitTermination(10, TimeUnit.SECONDS); // ждем завершения всех задач указанное время


        for (Future<String> future : results){
            System.out.println(future.get()); // future.get() это метод Future, который получает реультат выполнения задачи
        }

        System.out.println("FINISH"); // это выводится после работы всех потоков , потому что вызов invokeAll() блокирует маин
    }

    // имплементирует Callable<?> потому что нам нужен результат задачи
    // тк он дженерик то мы може указать любой тип значения
    // если имплементриует Runnable то результата не будет, просто задача заупустится и все
    static class MyCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println("Starting: " + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("Finished: " + Thread.currentThread().getName());
            return "check out";
        }
    }

}
