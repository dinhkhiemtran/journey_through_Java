package main.maps;

import java.util.Optional;
import java.util.TreeMap;

public class Say {

    private static final long MAX_NUMBER = 999_999_999_999L;

    private static TreeMap<Long, String> mapping = new TreeMap<>();

    static {
        mapping.put(0L, "zero");
        mapping.put(1L, "one");
        mapping.put(2L, "two");
        mapping.put(3L, "three");
        mapping.put(4L, "four");
        mapping.put(5L, "five");
        mapping.put(6L, "six");
        mapping.put(7L, "seven");
        mapping.put(8L, "eight");
        mapping.put(9L, "nine");
        mapping.put(10L, "ten");
        mapping.put(11L, "eleven");
        mapping.put(12L, "twelve");
        mapping.put(13L, "thirteen");
        mapping.put(14L, "fourteen");
        mapping.put(15L, "fifteen");
        mapping.put(16L, "sixteen");
        mapping.put(17L, "seventeen");
        mapping.put(18L, "eighteen");
        mapping.put(19L, "nineteen");
        mapping.put(20L, "twenty");
        mapping.put(30L, "thirty");
        mapping.put(40L, "forty");
        mapping.put(50L, "fifty");
        mapping.put(60L, "sixty");
        mapping.put(70L, "seventy");
        mapping.put(80L, "eighty");
        mapping.put(90L, "ninety");
        mapping.put(100L, "hundred");
        mapping.put(1000L, "thousand");
        mapping.put(1000_000L, "million");
        mapping.put(1000_000_000L, "billion");
    }

    public String say(long number) {
        if (number < 0 || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (number < 100) {
            return Optional.ofNullable(mapping.get(number))
                    .orElseGet(() ->
                            mapping.floorEntry(number)
                                    .getValue() + "-" + this.say(number % 10));
        }
        return this.say(number / mapping.floorKey(number))
                + " "
                + Optional.ofNullable(mapping.get(number))
                .orElseGet(() ->
                        mapping.floorEntry(number).getValue()
                                + (number % mapping.floorKey(number) > 0 ? " "
                                + this.say(number % mapping.floorKey(number)) : ""));
    }

    public static void main(String[] args) {
        Say say = new Say();
        System.out.println(say.say(9000_000_000L));
    }
}
