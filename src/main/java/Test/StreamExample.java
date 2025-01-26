package Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public StreamExample() {



        // создание потока
        Stream<Integer> streamCreateNumber1 = Stream.of(1, 2, 3, 4);
        Stream<Integer> streamCreateNumber2 = Stream.of(1, -3, 4, 22, -22, 221, -11);


        //слияние потоков
        Stream<Integer> streamPlusStream = Stream.concat(streamCreateNumber1, streamCreateNumber2);

        //фильтрация по условию
        Stream<Integer> filtrExample = streamCreateNumber2.filter(x -> (x < 0)); // x < 0

        // сортировка данных
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);

        // numbers.stream()
        //    .sorted() // Сортировка в естественном порядке (возрастающем)
          //    .forEach(System.out::println);

        // отбрасывание дупликатов
        Stream<Integer> duplicateNumbers = Stream.of(1, 2, 2, 2, 2, 4, 4, 4, 44, 45, 5, 5, 5, 5);
        Stream<Integer> distinctExaple = duplicateNumbers.distinct(); //остаются оригиналы 1 2 4 44 45 5

        // поток содержит только первые N элементы
        Stream<Integer> noLimitNumbers = Stream.of(1, 2, 3, 4, 4, 4, 2, 1, 2, 3, 2, 2, 2);
        Stream<Integer> limitNumbers = noLimitNumbers.limit(6); // содержит только первые 6 элементов

        // поток содержит все данные потока источника , но скипает первые N элементы
        Stream<Integer> noSkipStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 5, 4, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> skipNumbers = noSkipStream.skip(7); // сожержит все элементы кроме первых 7


    }



}


class dataConversion{

    // преобразование данных число в строку
    Stream<Integer> streamNumber = Stream.of(1,2,3,4,5);
    Stream<String> streamString = streamNumber.map((x) -> String.valueOf(x)); // можно короче - stream.map(String::valueOf);

    // теперь из строки в число
    Stream<Integer> streamNumberByString = streamString.map(Integer::parseInt);

    //Преобразование строки в URI (закомментил код потому что идеа ругается)
    /* ArrayList<String> list = new ArrayList<>();
    list.add("https://google.com");
    list.add("https://linkedin.com");
    list.add("https://yandex.com");

    Stream<URI> stream = list.stream().map(str ->
    */

    // пример преобразования строк в верхний регистр
    public static void main2() {
        Stream<String> stream = Stream.of("Не", "волнуйтесь", "если", "что-то", "не", "работает.", "Если", "бы", "всё", "работало", "вас", "бы", "уволили.");

        toUpperCase(stream).forEach(System.out::println);
    }

    public static Stream<String> toUpperCase(Stream<String> strings) {

        return strings.map(String::toUpperCase);
    }


    // второй пример можно посмотреть в папке quests;

}

class anyMatchExample {


    // пример AnyMatch сначала провекрка хотя бы одного элемента больше 0 , потом фильтрация только отрицательных и снова проверка
    Stream<Integer> stream = Stream.of(1,2,3,4,5);
    boolean result = stream.anyMatch(x -> x > 0); // true
    boolean result2 = stream.filter(x -> x < 0).anyMatch(x -> x > 0); // false

    //пример AllMatch проверка уже всех элементов
    Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6,7,8,9);
    boolean result3 = stream2.allMatch(x -> x > 0); // true
    boolean result4 = stream2.allMatch(x -> x < 0); // false
    boolean result5 = stream2.filter(x -> x > 0).allMatch(x -> x > 0); // true отфильтровали элементы больше 0 потом проверили остались они или нет

    // пример противоположного noneMatch проверка идет что таких элементов нет вообще
    /*
    Stream<Integer> stream3 = Stream.of(1,2,3,-1,-2,-2,-3,-44);
    Stream<Integer> stream4 = stream3.noneMatch(x -> x > 0); // false потому что они есть
    Stream<Integer> stream5 = stream3.filter(x -> x < 0).noneMatch(x -> x > 0); // true отому что сначала фильтруем только отрицательные и потом проверяем что нет полоительных
    */
}






