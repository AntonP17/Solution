package Test.Generics;
/*
Вход воспрещен!
*/

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericEx6 {

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy larsik = new Puppy("Larsik");
        Cat barsik = new Cat("Barsik");
        Kitten keksik = new Kitten("Keksik");

        House dogHouse = new House();
        dogHouse.enter(bruno);
        dogHouse.enter(larsik);
        dogHouse.enter(barsik);
        System.out.println(dogHouse.toString());

        House catHouse = new House();
        catHouse.enter(barsik);
        catHouse.enter(keksik);
        catHouse.enter(bruno);
        System.out.println(catHouse.toString());

        /// ///////////////////////////////////////////////////////////////////////////////////////////////

        House<Dog> dogHouseTEST = new House<>();
        dogHouse.enter(bruno);
        dogHouse.enter(larsik);
        // dogHouse.enter(barsik); // Это вызовет ошибку компиляции, что правильно
        System.out.println(dogHouse.toString());

        House<Cat> catHouseTEST = new House<>();
        catHouse.enter(barsik);
        catHouse.enter(keksik);
        // catHouse.enter(bruno); // Это вызовет ошибку компиляции, что правильно
        System.out.println(catHouse.toString());
    }
}

class House <T> {

        private List<T> residents = new ArrayList();

        public void enter(T resident) {
            residents.add(resident);
         //  checkConflicts();
        }

        public void leave(T resident) {
            residents.remove(resident);
        }

//        private void checkConflicts() {
//            boolean conflict = false;
//            for (Object resident : residents) {
//                if (resident instanceof Dog) {
//                    conflict = true;
//                }
//            }
//
//            if (conflict) {
//                Iterator iterator = residents.iterator();
//                while (iterator.hasNext()) {
//                    Object resident = iterator.next();
//                    if (resident instanceof Cat) {
//                        iterator.remove();
//                    }
//                }
//            }
//        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("В доме находятся:\n");
            for (Object resident : residents) {
                builder.append(resident.toString()).append("\n");
            }
            return builder.toString();
        }

    }


    class Kitten extends Cat {

        public Kitten(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Котенок " + name;
        }
    }


    class Dog {

        protected String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Пес " + name;
        }
    }

     class Puppy extends Dog {

        public Puppy(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Щенок " + name;
        }
    }

    class Cat {

        protected String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Кот " + name;
        }
    }




//MEDIUM Вход воспрещен!
//
//Проанализируй классы в задаче.
//В методе main создано два дома: один для котов и один для собак.
//        Однако сейчас, когда в дом для кошек заходит собака, возникает конфликт и все находящиеся в нем коты вынуждены покинуть дом (метод checkConflicts).
//Помоги котам защитить свой дом от посторонних, а также не позволить им случайно заходить в дом для собак.
//Для этого параметризируй House типом T и внеси соответствующие правки в реализацию класса.
//Метод main не принимает участие в тестировании.
//        Требования:
//        •	•
//Класс House должен быть параметризован с типом T. +
//        •	•
//Поле residents в классе House должно быть параметризовано типом T. +
//        •	•
//Метод enter в классе House должен принимать объект типа T. +
//        •	•
//Метод leave в классе House должен принимать объект типа T. +
//        •	•
//Метод checkConflicts в классе House больше не нужен и должен быть удален. +

