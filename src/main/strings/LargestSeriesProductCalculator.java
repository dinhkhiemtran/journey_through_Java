package main.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestSeriesProductCalculator {

    private final List<Integer> inputNumber;

    public LargestSeriesProductCalculator(String inputNumber) {
        if(inputNumber == null){
            throw new IllegalArgumentException("String to search must be non-null.");
        }
        if(!inputNumber.matches("\\d*")){
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
        this.inputNumber = Arrays.stream(inputNumber.split(""))
                .filter(c -> !c.isEmpty())
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toList());
    }

    public long calculateLargestProductForSeriesLength(int numberOfDigits) {
        if(inputNumber.size() < numberOfDigits){
            throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        }
        if(numberOfDigits < 0){
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        return IntStream.range(0, inputNumber.size() - numberOfDigits + 1)
                .mapToObj(i -> inputNumber.subList(i, i + numberOfDigits))
                .mapToLong(lst ->
                        lst.stream()
                                .mapToLong(l -> l)
                                .reduce(1L, (acc, e) -> acc * e))
                .max().orElse(1);
    }
}
