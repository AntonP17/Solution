package Test.JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JSONex3 {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        // ТУТ СНОВА ОБЯЗАТЕЛНО ПОДКЛЮЧИТЬ БИБЛИОТЕКУ jackson.databind.ObjectMapper

       ObjectMapper mapper = new ObjectMapper(); // тут так же нужен оьект ObjectMapper для сериализации
        return mapper.readValue(new FileReader(new File(fileName)), clazz); // тут используется уже не запись
        // а чтение из файла в котором содержится JSON


    }

    public static void main(String[] args) {

    }
}
