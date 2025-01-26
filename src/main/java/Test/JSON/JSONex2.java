package Test.JSON;

import java.io.IOException;
import java.io.StringWriter;

public class JSONex2 {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        StringWriter writer = new StringWriter();
        convertToJSON(writer, cat);
        System.out.println(writer.toString());
    }

    // ТУТ ТАК ЖЕ ОБЯЗАТЕЛЬНО ДОБАВИТЬ БИБЛИОТЕКУ jackson.databind
    // тогда сможем пользоваться всеми аннотациями

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
       // ObjectMapper mapper = new ObjectMapper();
       // mapper.writeValue(writer, object);
    }

  //  @JsonAutoDetect
    public static class Cat {

     //   @JsonProperty("wildAnimal")
        public String name;

      //  @JsonIgnore
        public int age;

     //   @JsonProperty("over")
        public int weight;

        Cat() {
        }
    }
}
