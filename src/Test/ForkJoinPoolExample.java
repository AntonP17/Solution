package Test;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinPoolExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final int MAX = 16;

        List<Integer> test = IntStream.range(1, MAX+1)
                .boxed()
                .toList();

//        for (Iterator<Integer> iterator = test.iterator(); iterator.hasNext(); ){
//            System.out.println(iterator.next());
//        }
        // этот код такой же как верхний , только делает параллельно, делит коллекцию пополам
        // он позволяет делать разделение
//          Spliterator<Integer> sp1 = test.spliterator();
//          Spliterator<Integer> sp2 = sp1.trySplit();
//          Spliterator<Integer> sp3 =  sp1.trySplit();
//          Spliterator<Integer> sp4 =  sp2.trySplit();
//
//          sp1.forEachRemaining(i -> System.out.println(i));
//        System.out.println("------>>>>>");
//          sp2.forEachRemaining(i -> System.out.println(i));
//        System.out.println("------>>>>>");
//        sp3.forEachRemaining(i -> System.out.println(i));
//        System.out.println("------>>>>>");
//        sp4.forEachRemaining(i -> System.out.println(i));


        // тут мы сами создаем пул  с нашим нужным колвом потоков
        ForkJoinPool pool = new ForkJoinPool(MAX);
        pool.submit(() -> // передаем запрос (код ниже который передаем)

                // а тут как раз таки и делается параллельно
                // тут используется ForkJoinPool и у него по умолчанию 8 потоков = 8 ядрам процессора

                test.parallelStream() // начало нашего запроса
                        .forEach(i -> {
                            System.out.println("Start: " + Thread.currentThread().getId() + ":" + i);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.getMessage();
                            }
                            System.out.println("Finish: " + Thread.currentThread().getId() + ":" + i);
                        })).get();

        System.out.println("FINISH");

    }

}
