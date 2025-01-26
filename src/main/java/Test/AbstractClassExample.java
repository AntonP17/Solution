package Test;

// пример создания абстрактного класса Animal

public abstract class AbstractClassExample{

    public void eat(){
        System.out.println("Animal is eating");
    }

    public abstract void makeSound();

}

// создание класса Dog , где переопределен метод
class Dog2 extends AbstractClassExample{

    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }
}

// создание класса Cat , где переопределен метод
class Cat2 extends AbstractClassExample{

    @Override
    public void makeSound() {
        System.out.println("meow meow");
    }
}

// точка начала программы
class animalTest {
    public static void main(String[] args) {
        Dog2 dog = new Dog2();
        Cat2 cat = new Cat2();
        dog.makeSound(); // переопределенный метод
        cat.makeSound(); // переопределенный метод
        dog.eat(); // общий метод
        cat.eat(); // общий метод



    }
}
