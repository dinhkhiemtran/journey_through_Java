package main.lists;

import java.util.*;
import java.util.stream.Collectors;

public class ChangeCalculator {

    private final TreeSet<Integer> coins;

    public ChangeCalculator(List<Integer> list) {
        coins = new TreeSet<>(Comparator.reverseOrder());
        coins.addAll(list);
    }

    public List<Integer> computeMostEfficientChange(int total) {
        if (total < 0) throw new IllegalArgumentException("Negative totals are not allowed.");
        List<Integer> result = pruneResult(total);
        if (sumOf(result) != total)
            throw new IllegalArgumentException(String.format("The total %d cannot be represented in the given currency.", total));
        return result;
    }

    private int sumOf(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private List<Integer> pruneResult(int total) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Collections.singletonList(0));
        while (!queue.isEmpty()) {
            final List<Integer> candidate = queue.remove();
            final int sum = sumOf(candidate);
            if (total == sum)
                return candidate.stream()
                        .filter(coins::contains)
                        .sorted(Integer::compareTo)
                        .collect(Collectors.toUnmodifiableList());
            coins.stream()
                    .filter(coin -> total >= sum + coin)
                    .filter(coin -> notDuplicated(queue, sum + coin))
                    .map(coin -> copyAndAppend(candidate, coin))
                    .forEach(queue::add);
        }
        return Collections.emptyList();
    }

    private List<Integer> copyAndAppend(List<Integer> candidate, Integer... numbers) {
        ArrayList<Integer> newList = new ArrayList<>(candidate);
        Collections.addAll(newList, numbers);
        return Collections.unmodifiableList(newList);
    }

    private boolean notDuplicated(Queue<List<Integer>> queue, int value) {
        return queue.stream().mapToInt(this::sumOf).noneMatch(i -> i == value);
    }
}
