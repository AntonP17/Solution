package Test.XML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.IOException;
import java.io.StringReader;


// ТУТ ГЛАНОЕ ПОМНИТЬ АЛГОРИТМ jaxbcontext , маршалер, унмаршаллер, преобразование в обьект

public class XMLex2 {
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlData = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        Cat cat = convertFromXmlToNormal(xmlData, Cat.class);
        System.out.println(cat);
    }

    public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz) throws IOException, JAXBException {

        // create StringReader
        StringReader reader = new StringReader(xmlData);

        // create context
        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

        // create Unmarshaller
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        // преобразуем XML в нужный обьект
        return (T) unmarshaller.unmarshal(reader);
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
