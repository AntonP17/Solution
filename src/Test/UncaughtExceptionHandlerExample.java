package Test;

import java.util.TimerTask;

public class UncaughtExceptionHandlerExample extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public UncaughtExceptionHandlerExample(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String threadName = t.getName();
                String maskName = threadName.replaceAll(".", "*");
                System.out.println(e.getMessage().replaceAll(threadName,maskName));
            }
        };    //init handler here


    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                throw new RuntimeException("Test test test");
            }
        };

        UncaughtExceptionHandlerExample u = new UncaughtExceptionHandlerExample(task);

        Thread t = new Thread(u);
        t.setUncaughtExceptionHandler(u.handler);
        t.start();
    }
}
