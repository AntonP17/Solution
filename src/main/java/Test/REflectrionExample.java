package Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class REflectrionExample {
    public static void main(String[] args) throws Exception {
        SomeKey someKey = new SomeKey();
        someKey.name = "test";

        SomeKey someKeyNew = new SomeKey();
        someKeyNew.name = "testNew";

        SomeValue value = new SomeValue(someKey);

        Cache<SomeKey, SomeValue> cache = new Cache<>();
        cache.put(value);

        SomeValue existingValueFromCache = cache.getByKey(someKey, SomeValue.class);
        System.out.println(existingValueFromCache);

        SomeValue newValueFromCache = cache.getByKey(someKeyNew, SomeValue.class);
        System.out.println(newValueFromCache);

        System.out.println(cache.size());
        /* Expected output:
        SomeValue{myKey=SomeKey{name='test'}}
        SomeValue{myKey=SomeKey{name='testNew'}}
        2
         */
    }

    public static class SomeKey {
        String name;

        @Override
        public String toString() {
            return "SomeKey{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class SomeValue {
        private SomeKey myKey;

        public SomeValue() {
        }

        public SomeValue(SomeKey myKey) {        //use this constructor
            this.myKey = myKey;
        }

        private SomeKey getKey() {
            return myKey;
        }

        @Override
        public String toString() {
            return "SomeValue{" +
                    "myKey=" + myKey +
                    '}';
        }
    }
}

 class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here

        if (!cache.containsKey(key)){
            Constructor<V> constructor = clazz.getConstructor(key.getClass()); // получить конструктор с 1 параметром
            V value = constructor.newInstance(key); // новый экземпляр
            cache.put(key, value);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        //TODO add your code here
        try {
            Method getKey = obj.getClass().getDeclaredMethod("getKey"); // ссылка на метод
            getKey.setAccessible(true); // получаем доступ к приватному через рефлексию
            K key = (K) getKey.invoke(obj); // вызвать метод и получить ключ
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        } catch (IllegalAccessException e) {
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}


