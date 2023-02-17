package main.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sieve {

    private int maxPrime;

    public Sieve(int maxPrime) {
        this.maxPrime = maxPrime;
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .allMatch(n -> number % n != 0);
    }

    public List<Integer> getPrimes() {
        return IntStream.rangeClosed(2, maxPrime)
                .filter(Sieve::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }
}
