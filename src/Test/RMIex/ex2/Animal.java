package Test.RMIex.ex2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote { // тут тоже самое как и в примере 1 (интерйефс это контракт)
    void speak() throws RemoteException;

    void printName() throws RemoteException;
}
