package main.numbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {

    private static long FACTOR = 2l;

    public List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> list = new ArrayList<>();
        while (FACTOR <= number && number > 1) {
            if (number % FACTOR == 0) {
                list.add(FACTOR);
                number /= FACTOR;
                FACTOR = 2l;
            } else {
                FACTOR++;
            }
        }
        return list;
    }
}
