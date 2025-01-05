package Test;

public class Synhronize {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Synhronize solution, final Object o1, final Object o2) throws Exception {
        //do something here
        Thread thread1 = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                synchronized (o1){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e){
                        System.out.println("захват о1 прерван");
                    }
                    synchronized (o2){
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            System.out.println("захват о2 прерван");
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new java.lang.Runnable() {
            @Override
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(2000);


        thread2.interrupt();
        return !thread2.isAlive();


    }

    public static void main(String[] args) throws Exception {
        final Synhronize solution = new Synhronize();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
