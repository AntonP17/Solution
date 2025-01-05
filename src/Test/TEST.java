package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TEST {

    public static void main(String[] args) {

        List<String> init = new ArrayList<>();
        //List<String> init = Collections.synchronizedList(new ArrayList<>());
        init.add("NAME: -1");
        init.add("NAME: -2");

        List<Person2> test = new ArrayList<>();
            for (int i = 0; i < 10000; i++){
                test.add(new Person2((long) i, "Name: " + i));
            }

        List<String> res = test.parallelStream()
                .map(Person2::getName)
                .collect(Collectors.toList());

        init.addAll(res);


//        test.parallelStream()
//                .map(p -> p.getName())
//                .forEach(s -> init.add(s));

        System.out.println("FINISH " + init.size());
    }
}

class Person2{


    private long id;
    private String name;


    public Person2(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}