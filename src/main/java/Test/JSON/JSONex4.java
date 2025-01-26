package Test.JSON;

import java.util.ArrayList;
import java.util.List;

public class JSONex4 {
    public List<Animal> animals = new ArrayList<>();

    // ТУТ ТАК ЖЕ ОБЯЗАТЕЛЬНО ДОБАВИТЬ БИБЛИОТЕКУ jackson.databind
    // тогда сможем пользоваться всеми аннотациями

//    @JsonTypeInfo(
//            use = JsonTypeInfo.Id.NAME, // Использует имя типа для идентификации.
//            include = JsonTypeInfo.As.PROPERTY, // Добавляет поле type в JSON
//            property = "type" // Указывает имя поля, которое будет хранить тип.
//    )
//    @JsonSubTypes({ // Определяет список подтипов, которые могут быть сериализованы и десериализованы.
//            @JsonSubTypes.Type(value = Dog.class, name = "dog"),
//            @JsonSubTypes.Type(value = Cat.class, name = "cat")
//    })

    // @JsonTypeInfo(
     //       use = JsonTypeInfo.Id.CLASS, // использует Полное имя класса (включая пакет).,
    // есть еще вариант MINIMAL_CLASS	Минимальное имя класса (без пакета).
      //      include = As.PROPERTY,
       //     property = "className")
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

 //   @JsonTypeName("dog") // подтип
    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

 //   @JsonTypeName("cat")  // подтип
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}
