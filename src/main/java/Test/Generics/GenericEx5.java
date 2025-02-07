package Test.Generics;

/*
Wildcards
*/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GenericEx5 {

    public static <D, H extends D, S extends H> void add(List<? super S> destinationList, List<? extends S> sourceList) {

        destinationList.addAll(sourceList);

//     можно так но идет бессмысленное приведение типов , wildcards позволяет работать с любым обьектом, но опасно добавлять в коллекцию потмоу что может быть null
//        public static <D, H extends D, S extends H> void add(List<? extends D> destinationList, List<? extends S> sourceList) {
//            ListIterator<D> destListIterator = (ListIterator<D>) destinationList.listIterator();
//            ListIterator<S> srcListIterator = (ListIterator<S>) sourceList.listIterator();
//            for (int i = 0; i < sourceList.size(); i++) {
//                destListIterator.add(srcListIterator.next());
//            }
//        }

    }


    public static void main(String[] args) {
        List<B> destination = new ArrayList<>();
        destination.add(new B());
        List<C> source = new ArrayList<>();
        source.add(new C());
        add(destination, source);
        System.out.println(destination);
        System.out.println(source);

        /*
[com.javarush.test.level39.lesson08.task01.Solution$C@203b4f0e, com.javarush.test.level39.lesson08.task01.Solution$B@15c330aa]
[com.javarush.test.level39.lesson08.task01.Solution$C@203b4f0e]
         */
    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }
}


//MEDIUM Wildcards
//
//Перепиши дженерики в методе add иcпользуя wildcards.
//Логику не меняй.
//Не оставляй закомментированный код.
//Требования:
//        •	•
//Вывод на экран должен соответствовать условию задачи.
//•	•
//Логика метода add должна быть сохранена.
//        •	•
//В методе add должны использоваться wildcards.
//        •	•
//Метод add должен быть статическим.

