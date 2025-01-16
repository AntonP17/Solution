package Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxyExample {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        // интерфейс                           // класс
        SomeInterfaceWithMethods original = new SomeInterfaceWithMethodsImpl(); // для создания прокси нужен оригинальный обьект


        // тут гоавное запомнить что при создании прокси - в статический метод передаются сначала ClassLoader
        // потом getClass().getInterfaces, последний аргумент это класс(который implements InvocationHandler)
        // в последний аргумент передается наш целевой обьект для которого надо создать прокси
        // обязательно делать приведение типа
        SomeInterfaceWithMethods result = (SomeInterfaceWithMethods) Proxy.newProxyInstance(
                original.getClass().getClassLoader(), original.getClass().getInterfaces(),
                new CustomInvocationHandler(original));


        return result;
    }
}

//наш прокси , он работает только для классов кто реализует интефейс
// позволяет вызывать и изменять приватные методы (нарушает инкапсуляцию) во время выполнения программы
class CustomInvocationHandler implements InvocationHandler {

    private SomeInterfaceWithMethods target; // целевой интерфейс , все классы которые от него имплементятся попадают под нашу цель

    public CustomInvocationHandler(SomeInterfaceWithMethods target) {
        this.target = target;
    }

    @Override // метод принимает обьект , метод , аргументы
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in"); // меняем наш целевой метод добавив новое поведение

        Object result = method.invoke(target, args);  // наш целевой объект и аргументы

        System.out.println(method.getName() + " out"); // меняем наш целевой метод добавив новое поведение

        return result;
    }
}

class SomeInterfaceWithMethodsImpl implements SomeInterfaceWithMethods {
    public void voidMethodWithoutArgs() {
        System.out.println("inside voidMethodWithoutArgs");
    }

    public String stringMethodWithoutArgs() {
        System.out.println("inside stringMethodWithoutArgs");
        return null;
    }

    public void voidMethodWithIntArg(int i) {
        System.out.println("inside voidMethodWithIntArg");
        voidMethodWithoutArgs();
    }
}

interface SomeInterfaceWithMethods {
    void voidMethodWithoutArgs();

    String stringMethodWithoutArgs();

    void voidMethodWithIntArg(int i);
}
