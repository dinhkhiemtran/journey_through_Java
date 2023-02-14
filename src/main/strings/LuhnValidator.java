package main.strings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LuhnValidator {

    public static int[] getDigits(String candidate) {
        int[] digits = new StringBuilder(candidate)
                .reverse()
                .toString()
                .replace(" ", "")
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        return digits;
    }

    private static boolean isValid(Integer digit) {
        return digit < 0 || digit > 9;
    }

    private static Integer calculateDigitValue(Integer digit, Integer index) {
        if (index % 2 == 0) {
            return digit;
        }
        int digitDoubled = digit << 1;
        if (digitDoubled >= 10) {
            return digitDoubled - 9;
        }
        return digitDoubled;
    }

    public boolean isValid(String candidate) {
        int[] digits = getDigits(candidate);
        if (digits.length < 2) {
            return false;
        }
        if (Arrays.stream(digits).anyMatch(LuhnValidator::isValid)) {
            return false;
        }
        int sum = IntStream.range(0, digits.length)
                .map(i -> calculateDigitValue(digits[i], i))
                .sum();
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        LuhnValidator luhnValidator = new LuhnValidator();
        String digits = "79927398713";
        boolean isValid = luhnValidator.isValid(digits);
        if (isValid) {
            System.out.println("This is a valid.");
        } else {
            System.out.printf("This is not a valid.");
        }
    }
}