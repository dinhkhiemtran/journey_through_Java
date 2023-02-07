package main.lists;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Flatten {

    public <T> List<T> flatten(List<List<T>> list) {
        return list.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = IntStream.rangeClosed(1, 3)
                .boxed()
                .map(i -> Collections.nCopies(4, i))
                .collect(Collectors.toList());
        Flatten flatten = new Flatten();
        System.out.println(flatten.flatten(listOfLists));
    }
}
