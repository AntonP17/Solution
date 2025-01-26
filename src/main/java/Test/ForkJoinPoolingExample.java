package Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolingExample {
    public static void main(String[] args) {

        ForkJoinPool fjp = new ForkJoinPool(2);
        double[] nums = new double[10000];

        for (int i = 0; i < nums.length; i++){
            nums[i] =(double) i;
        }

        MyTask task = new MyTask(nums,0,nums.length,1000);

        long begunT = System.nanoTime();

        double result = fjp.invoke(task);

        long endT = System.nanoTime();

        System.out.println("Результат равен " + result);
        System.out.println("Время затрачено " + (endT - begunT) + "нс");
    }
}

// RecursiveTask<?> возвращает реультат, поэтому в методе compute оже надо поменять возвращаемое значнеие
// RecursiveAction не возвращает
class MyTask extends RecursiveTask<Double> {

    int seqThreshold;
    double[] data;
    int start, end;
    double sum;

    public MyTask(double[] data, int start, int end, int seqThreshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.seqThreshold = seqThreshold;
    }

    @Override
    protected Double compute() {

        if ((end - start) < seqThreshold){
            for (int i = start; i < end; i++){
                sum += data[i];
            }
        } else {

            int middle = (start + end) / 2;

            MyTask taskA = new MyTask(data, start, middle, seqThreshold);
            MyTask taskB = new MyTask(data, middle, end, seqThreshold);

            taskA.fork();
            taskB.fork();

            sum = taskA.join() + taskB.join();
        }

        return sum;

    }

}
