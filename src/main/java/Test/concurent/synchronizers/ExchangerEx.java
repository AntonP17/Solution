package Test.concurent.synchronizers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Exchanger;

public class ExchangerEx {

    public static void main(String[] args) {

        Exchanger<String> ex = new Exchanger<>();

        Mike mike = new Mike(ex);
        Anket anket = new Anket(ex);
        //mike.interrupt();

    }

    static class Mike extends Thread{

        private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
        private Exchanger<String> exchanger;

        public Mike(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi my name is Mike");
                sleep(1000);
                exchanger.exchange("I am 27 years old");

            } catch (InterruptedException e) {
                LOGGER.error("Thread {} was interrupted", Thread.currentThread().getName());
            }
        }
    }

    static class Anket extends Thread{

        private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
        private Exchanger<String> exchanger;

        public Anket(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                LOGGER.info(exchanger.exchange(null));
                LOGGER.info(exchanger.exchange(null));
            }catch (InterruptedException e) {
                LOGGER.error("Thread {} was interrupted", Thread.currentThread().getName());
            }
        }
    }
}
