package main.arrays;

import java.util.TreeMap;

public class RomanNumerals {

    private int numerals;

    private final static TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    static {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    public RomanNumerals(int numerals) {
        this.numerals = numerals;
    }

    private String toRoman(int number) {
        int previous = romanNumerals.floorKey(number);
        System.out.println(previous);
        if (number == previous) {
            return romanNumerals.get(number);
        }
        return romanNumerals.get(previous) + toRoman(number - previous);
    }

    public String getRomanNumeral() {
        return toRoman(numerals);
    }

    public static void main(String[] args) {
        int numerals = 1990;
        RomanNumerals romanNumerals = new RomanNumerals(numerals);
        System.out.println(romanNumerals.getRomanNumeral());
    }

}
