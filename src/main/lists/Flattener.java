package main.lists;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Flattener {

    public List flatten(List list) {
        List<Object> result = new ArrayList<>();

        for (Object o : list) {
            if (o instanceof List) {
                result.addAll(flatten((List) o));
            } else if (o != null) {
                result.add(o);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List list = asList(1, '2', 3, 4, 5, "six", "7", 8);
        Flattener flattener = new Flattener();
        System.out.println(flattener.flatten(list));
    }
}
