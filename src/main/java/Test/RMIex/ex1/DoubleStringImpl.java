package Test.RMIex.ex1;

import java.rmi.RemoteException;

public class DoubleStringImpl implements DoubleString { // класс кто имплементит интерфейс
    public String doubleString(String str) throws RemoteException {
        return str + str;
    }
}
