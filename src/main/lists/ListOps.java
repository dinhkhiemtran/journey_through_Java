package main.lists;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListOps {

    public static <T> List<T> append(List<T> list1, List<T> list2) {
        List<T> results = new ArrayList<>(list1);
        results.addAll(list2);
        return results;
    }

    public static <T> List<T> concat(List<List<T>> listOfLists) {
        List<T> results = new ArrayList<>();
        for (List<T> list : listOfLists) {
            results = append(results, list);
        }
        return results;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> results = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                results.add(e);
            }
        }
        return results;
    }

    public static <T> int size(List<T> list) {
        return list.size();
    }

    public static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        List<U> newList = new ArrayList<>();
        for (T e : list) {
            newList.add(transform.apply(e));
        }
        return newList;
    }

    public static <T> List<T> reverse(List<T> list) {
        Collections.reverse(list);
        return list;
    }

    public static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        U accum = initial;
        for (T e : list) {
            accum = f.apply(accum, e);
        }
        return accum;
    }

    public static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        U accum = initial;
        List<T> revList = reverse(list);
        for (T t : revList) {
            accum = f.apply(t, accum);
        }
        return accum;
    }

    private ListOps() {
        // No instances.
    }
}
