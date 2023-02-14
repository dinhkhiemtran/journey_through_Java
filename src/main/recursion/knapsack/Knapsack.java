package main.recursion.knapsack;

import main.recursion.knapsack.Item;

import java.util.List;

public class Knapsack {

    public int maximumValue(int capacity, List<Item> items) {
        return items.stream()
                .mapToInt(i -> {
                    if (i.getWeight() > capacity) {
                        return 0;
                    }
                    return i.getValue() + maximumValue(capacity - i.getWeight(),
                            items.subList(items.indexOf(i) + 1, items.size()));
                }).max().orElse(0);
    }
}
