package Test.RMIex.ex1;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIexample1 {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    // КЛИЕНТ
    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код для Клиента
            try {
                DoubleString doubleString = (DoubleString) registry.lookup(UNIC_BINDING_NAME); // получаем наш интерфейс удаленно ,
                // RMI как и прокси работает на уровне интерфейса
                String result = doubleString.doubleString("Hello "); // вызываем удаленный метод
                System.out.println(result);
            } catch (RemoteException | NotBoundException e){
                e.getMessage();
            }

        }
    });

    // СЕРВЕР
    public static void main(String[] args) {
        // Pretend we're starting an RMI server as the main thread
        Remote stub = null;
        try {
            registry = LocateRegistry.createRegistry(2099); // регистрируем порт
            final DoubleStringImpl service = new DoubleStringImpl(); // нужный обьект чьи методы вызовем удаленно(обьект долен имплементить интерфейс по которому работает RMI)

            stub = UnicastRemoteObject.exportObject(service, 0); // реестр удаленный обьектов
            registry.bind(UNIC_BINDING_NAME, stub); // регистрируем наш обьект с определенным именем (которое должен знать клиент)
            // в реестре удаленных обьектов
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        // Start the client
        CLIENT_THREAD.start();
    }
}
