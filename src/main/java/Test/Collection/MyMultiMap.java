package Test.Collection;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override // +
    public int size() {
        //напишите тут ваш код
        int size = 0;
        for (List<V> list : map.values()){
            size += list.size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {

        // Шаг 1: Получаем список значений для ключа
        List<V> values;

        // Если ключ уже есть в карте, получаем его список значений
        if (map.containsKey(key)) {
            values = map.get(key);
        } else {
            // Если ключа нет, создаем новый список и добавляем его в карту
            values = new ArrayList<>();
            map.put(key, values);
        }

        // Шаг 2: Сохраняем последний элемент до добавления нового значения
        V lastAdded = null;
        if (!values.isEmpty()) {
            lastAdded = values.get(values.size() - 1);
        }

        // Шаг 3: Если список достиг максимального размера, удаляем первый элемент
        if (values.size() == repeatCount) {
            values.remove(0);
        }

        // Шаг 4: Добавляем новое значение в конец списка
        values.add(value);

        // Шаг 5: Возвращаем последний добавленный элемент до текущего добавления
        return lastAdded;
    }

    @Override
    public V remove(Object key) {

        // Проверяем, содержится ли ключ в карте
        if (map.containsKey(key)) {
            // Получаем список значений для ключа
            List<V> values = map.get(key);

            // Если список не пуст, удаляем первый элемент и возвращаем его
            if (values != null && !values.isEmpty()) {
                V removedValue = values.remove(0); // Удаляем элемент с индексом 0

                // Если список стал пустым, удаляем всю пару ключ-значение
                if (values.isEmpty()) {
                    map.remove(key);
                }

                return removedValue;
            } else {
                // Если список пуст, удаляем всю пару ключ-значение
                map.remove(key);
                return null;
            }
        } else {
            // Если ключа нет в карте, возвращаем null
            return null;
        }
    }

    @Override // +
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override // +
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> list = new ArrayList<>();
        for (Map.Entry<K, List<V>> entry : map.entrySet()){
            list.addAll(entry.getValue());
        }
        return list;
    }

    @Override // +
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override // +
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        for (Map.Entry<K, List<V>> entry : map.entrySet()){
            for (V v : entry.getValue()){
                if (v.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new MyMultiMap<>(3);
        for (int i = 0; i < 7; i++) {
            map.put(i, i);
        }
        map.put(5, 56);
        map.put(5, 57);
        System.out.println(map.put(5, 58));             // Expected: 57

        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=56, 57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 9

        System.out.println(map.remove(5));              // Expected: 56
        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 8

        System.out.println(map.keySet());               // Expected: [0, 1, 2, 3, 4, 5, 6]
        System.out.println(map.values());               // Expected: [0, 1, 2, 3, 4, 57, 58, 6]

        System.out.println(map.containsKey(5));         // Expected: true
        System.out.println(map.containsValue(57));      // Expected: true
        System.out.println(map.containsValue(7));       // Expected: false
    }
}
