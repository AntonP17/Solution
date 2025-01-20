package Test.RMIex.ex2;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIexample2 {
    public static Registry registry;

    //КЛИЕНТ
    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //СЕРВЕР
    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {

        public static final String UNIQUE_BINDING_NAME = "server.calculator";

        @Override
        public void run() {
            //напишите тут ваш код

            try {

                Cat catService1 = new Cat("Brsik"); // создаем наши обькты которые хотим вызывать удаленно
                Dog dogService1 = new Dog("DRugok");

                registry = LocateRegistry.createRegistry(2099); // регистрируем порт
                Remote stub1 = UnicastRemoteObject.exportObject(catService1, 0); // реестр удаленных объектов.
                Remote stub2 = UnicastRemoteObject.exportObject(dogService1, 0);
                registry.bind("cat.class", stub1); // заглушка для удаленного вызова
                registry.bind("dog.class", stub2);


            }catch (RemoteException | AlreadyBoundException e){
                e.printStackTrace();
            }

        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
