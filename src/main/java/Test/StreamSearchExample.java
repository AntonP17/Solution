package Test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class StreamSearchExample {
    public StreamSearchExample() {

        // метод findFirs щет 1 элемент
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hi", "How", "Are you?");
        String str = list.stream()
                .findFirst().get();

        // метод findAny обрабатывает чисто любой элемент

        // метод min равнивает элементы и и возвращает минимальный

        String min = list.stream()
                .min((s1, s2) -> s1.length() - s2.length())
                .get();

        // метод max равнивает элементы и и возвращает max

        String max = list.stream()
                .max((s1, s2) -> s1.length() - s2.length())
                .get();


    }


}

class collectorsExample {


    // пример преобраования потока в множество
    public void streamToSet(){


        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Hie", "how", "are you");

        Set<String> result = list.stream()
                .filter( s -> Character.isUpperCase(s.charAt(0)) )
                .collect( Collectors.toSet() );

    }

    // пример преобразования в мапу
    public void streamToMap(){

        //1 пример
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a=2", "b=3", "c=4", "d==3");

        Map<String, String> result = list.stream()
                .map(e -> e.split("="))
                .filter(e -> e.length == 2)
                .collect(toMap(e -> e[0], e -> e[1]));




        // 2 пример
        var stringStream = Stream.of("JavaRush", "CodeGym", "Amigo", "Elly", "Kim", "Risha");
        getMap(stringStream).forEach((s, i) -> System.out.println(s + " - " + i));

    }

    public static Map<String, Integer> getMap(Stream<String> stringStream) {

        return stringStream.collect(toMap(e -> e,e -> e.length()));
    }

    //преобразование потока в строку
    public void streamToString() {

        // 1 пример
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a=2", "b=3", "c=4", "d==3");

        String result = list.stream().collect(joining(", ")); //результат строка a=2, b=3, c=4, d==3


        // 2 пример
        var stringStream = Stream.of("To", "be", "a", "programmer", "you", "need", "to", "code");

        System.out.println(getString(stringStream));
    }

    public static String getString(Stream<String> stringStream) {

        return stringStream.collect(joining(" "));  // краткая запись ,
        // нужно импортировать класс Collectors в код,
        // например: import static java.util.stream.Collectors.joining;.
        // Затем, метод joining(" ") может быть вызван непосредственно.

        // stringStream.collect(Collectors.joining(" ")); //Это полная форма записи метода joining()
        // с использованием класса Collectors явно указанного в коде.
        // В этом случае, нет необходимости импортировать Collectors с помощью import.
        // можно вызвать метод joining(" ") через класс Collectors напрямую.

}

}




