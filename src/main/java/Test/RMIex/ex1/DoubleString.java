package Test.RMIex.ex1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoubleString extends Remote { // так как на уровне интерфейса раюотает то нужно еще имплементится от Remote
    String doubleString(String str) throws RemoteException;
}
