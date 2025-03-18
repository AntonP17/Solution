package Test.InterView.tasks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementCounter{

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 5, 1, 5, 4);

        Map<Integer,Integer> result = countElements(list);

        printResult(result);
    }

    public static Map<Integer, Integer> countElements(List<Integer> list) {

        Map<Integer, Integer> elementCountMap = new HashMap<>();

        for (Integer elements : list) {
            elementCountMap.put(elements, elementCountMap.getOrDefault(elements, 0) + 1);
        }

        return elementCountMap;
    }

    public static void printResult(Map<Integer,Integer> result){
        System.out.print("{");
        int i = 0;
        for (Map.Entry<Integer,Integer> entry : result.entrySet()){
            System.out.print(entry.getKey() + ":" + entry.getValue());
            if (i < result.size() - 1){
                System.out.print(",");
            }
            i++;
        }
        System.out.println("}");
    }

}
