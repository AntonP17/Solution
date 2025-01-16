package Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class genericToProxy {
    public static void main(String[] args) {
        genericToProxy solution = new genericToProxy();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    // тут тема дженериков , запись <T extends Item> означает  T может быть любым классом/интерфейсом типа Item, либо потомком Item.
    // запись "Class<?> ..." additionalInterfaces означает о передаче классов дополнительных интерфейсов через аргументы переменной длины
    // <?> хначит что класс неизвестного типа и пофиг какой
    // "..." после типа означает что мы можем поменстить сюда лбое количество аргументов , но такой синтаксис должен быть только один и не более
    // потом при компиляции он создаст массив из этих типов
    public <T extends Item> T getProxy(Class<T> type, Class<?> ... additionalInterfaces){

        Class<?>[] interfaces = new Class<?>[additionalInterfaces.length + 1]; // массив обьектов класса неизвестног отипа,
        // размер на 1 больше чем длина дополнительных классов 2 аргумент

        interfaces[0] = type;
        System.arraycopy(additionalInterfaces, 0, interfaces, 1, additionalInterfaces.length);

        Object instance =  Proxy.newProxyInstance(this.getClass().getClassLoader(),
                interfaces,
                new ItemInvocationHandler());
        // тут гоавное запомнить что при создании прокси в статический метод передаются сначала ClassLoader
        // потом getClass().getInterfaces, последний аргумент это класс(который implements InvocationHandler)
        // в последний аргумент передается наш целевой обьект для которого надо создать прокси

        return (T) instance; // обязательно делать приведение типа
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}

class ItemInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}

interface Big extends Item {
}

interface Item {
}

interface Small {
}
