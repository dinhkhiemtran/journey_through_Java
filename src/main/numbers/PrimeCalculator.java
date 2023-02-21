package main.numbers;

import java.util.stream.IntStream;

public class PrimeCalculator {
    public int nth(int nth) {
        return IntStream.iterate(2, i -> i + 1)
                .filter(i -> IntStream.range(2, i)
                        .allMatch(e -> i % e != 0))
                .limit(nth)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("no prime in range " + nth));
    }
}
