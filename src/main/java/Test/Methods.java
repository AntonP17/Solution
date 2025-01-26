package Test;

public class Methods {
    public static void main(String[] args) {

        // создание обьекта класса Person и передача данных параметров в этод класс
        Person person1 = new Person();
        person1.name = "Anton";
        person1.age = 27;
        person1.sayHello();
        person1.speak();
        person1.sayNoAss();

        // создание 2 обьекта
        Person person2 = new Person();
        System.out.println("\n");
        person2.name = "Kiska";
        person2.age = 28;
        person2.sayHello();
        person2.speak();
        person2.sayAss();
        person2.getMoney();

    }
}


class Person{
    String name;
    int age;

    void speak(){
        System.out.print(", my name is " + name + ", me " + age + " years");

    }

    void sayHello(){
        System.out.print("Hello");
    }

    void sayAss(){
        System.out.print(", I am ass");
    }

    void sayNoAss(){
        System.out.print(", I am not ass.");
    }

    void getMoney(){
        System.out.print(", give me " + 2000 + " rub");
    }

}







