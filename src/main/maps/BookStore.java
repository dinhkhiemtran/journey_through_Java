package main.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BookStore {

    private static int BASE_COST = 8;

    private static Map<Integer, Double> COST_MULTIPLIER = new HashMap<>();

    static {
        COST_MULTIPLIER.put(1, 1.0);
        COST_MULTIPLIER.put(2, 0.95);
        COST_MULTIPLIER.put(3, 0.90);
        COST_MULTIPLIER.put(4, 0.80);
        COST_MULTIPLIER.put(5, 0.75);
    }

    public double calculateBasketCost(List<Integer> books) {
        Map<Integer, Long> bookPerType = books.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        if (bookPerType.isEmpty()) {
            return 0;
        }
        if (books.size() == 1) {
            Integer firstKey = bookPerType.keySet().iterator().next();
            Long numberOfBook = bookPerType.get(firstKey);
            return numberOfBook * BASE_COST;
        } else {
            double costOfNaiveAlgorithm = naiveAlgorithm(bookPerType);
            double costOfAlgorithmOfFour = algorithmOfFour(bookPerType);
            return Math.min(costOfAlgorithmOfFour, costOfNaiveAlgorithm);
        }
    }

    private double algorithmOfFour(Map<Integer, Long> bookPerType) {
        double cost = 0;
        while (!bookPerType.isEmpty()) {
            if (bookPerType.size() < 4) {
                cost += naiveAlgorithm(bookPerType);
                break;
            }
            List<Map.Entry<Integer, Long>> sortedBookOfType = bookPerType.entrySet().stream()
                    .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                    .collect(Collectors.toList());
            Map<Integer, Long> remainingBasket = new HashMap<>();
            pickEntry(sortedBookOfType.get(0), remainingBasket);
            pickEntry(sortedBookOfType.get(1), remainingBasket);
            pickEntry(sortedBookOfType.get(2), remainingBasket);
            pickEntry(sortedBookOfType.get(sortedBookOfType.size() - 1), remainingBasket);
            for (int i = 3; i < sortedBookOfType.size() - 1; i++) {
                remainingBasket.put(sortedBookOfType.get(i).getKey(), sortedBookOfType.get(i).getValue());
            }
            cost = cost + 4 * BASE_COST * COST_MULTIPLIER.get(4);
            bookPerType = remainingBasket;
        }
        return cost;
    }

    private void pickEntry(Map.Entry<Integer, Long> integerLongEntry, Map<Integer, Long> remainingBasket) {
        if (integerLongEntry.getValue() - 1 > 0) {
            remainingBasket.put(integerLongEntry.getKey(), integerLongEntry.getValue() - 1);
        }
    }

    private double naiveAlgorithm(Map<Integer, Long> bookPerType) {
        double cost = 0;
        while (!bookPerType.isEmpty()) {
            int numberOfDifferentBook = 0;
            Set<Map.Entry<Integer, Long>> entries = bookPerType.entrySet();
            Map<Integer, Long> remainingBasket = new HashMap<>();
            for (Map.Entry<Integer, Long> bookOfType : entries) {
                if (bookOfType.getValue() - 1 > 0) {
                    remainingBasket.put(bookOfType.getKey(), bookOfType.getValue() - 1);
                }
                numberOfDifferentBook++;
            }
            cost = cost + numberOfDifferentBook * BASE_COST * COST_MULTIPLIER.get(numberOfDifferentBook);
            bookPerType = remainingBasket;
        }
        return cost;
    }
}
