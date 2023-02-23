package main.maps;

import java.util.*;
import java.util.stream.Stream;

public class School {
    TreeMap<String, Integer> school;

    public School() {
        school = new TreeMap<>();
    }

    public void add(String name, Integer grade) {
        school.put(name, grade);
    }

    public List<String> roster() {
        Map<Integer, List<String>> map = new HashMap<>();
        for (Map.Entry<String, Integer> entry : school.entrySet()) {
            if (map.get(entry.getValue()) == null) {
                List<String> newList = new ArrayList<>();
                newList.add(entry.getKey());
                map.put(entry.getValue(), newList);
            } else {
                map.get(entry.getValue()).add(entry.getKey());
            }
        }
        List result = new ArrayList();
        Stream.of(map).forEach(l -> l.forEach(((k, v) -> result.addAll(v))));
        return result;
    }

    public List<String> grade(int grade) {
        List<String> sorted = new ArrayList<>();
        school.entrySet()
                .stream()
                .filter(x -> x.getValue() == 5)
                .forEach(x -> sorted.add(x.getKey()));
        return sorted;
    }
}
