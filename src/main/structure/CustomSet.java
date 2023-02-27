package main.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSet<T> {

    private HashSet<T> set;

    public CustomSet(List<T> set) {
        this.set = new HashSet<>();
        this.set.addAll(set);
    }

    public void add(T element) {
        set.add(element);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public boolean contains(T element) {
        return set.contains(element);
    }

    public boolean isSubset(CustomSet<T> customSet) {
        return customSet.set.parallelStream().allMatch(el -> set.contains(el));
    }

    public CustomSet<T> getIntersection(CustomSet<T> customSet) {
        return new CustomSet<T>(
                set.stream().filter(element -> customSet.set.contains(element)).collect(Collectors.toList()));
    }

    public CustomSet<T> getDifference(CustomSet<T> customSet) {
        return new CustomSet<T>(
                set.stream().filter(element -> !customSet.set.contains(element)).collect(Collectors.toList()));
    }

    public CustomSet<T> getUnion(CustomSet<T> customSet) {
        return new CustomSet<T>(Stream.concat(set.stream(), customSet.set.stream()).collect(Collectors.toList()));
    }

    public boolean isDisjoint(CustomSet<T> customSet) {
        return customSet.set.parallelStream().noneMatch(el -> set.contains(el));
    }

    public void print() {
        for (T element : set) {
            System.out.print(element);
            System.out.print(",");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        @SuppressWarnings("unchecked")
        CustomSet<T> other = (CustomSet<T>) obj;
        return isSubset(other) && other.isSubset(this);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        CustomSet customSet = new CustomSet(list);
        customSet.add(1);
        customSet.print();
    }
}
