package main.encode_decode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BaseConverter {

    private int value = 0;

    public BaseConverter(int base, int[] number) {
        if (base < 2) throw new IllegalArgumentException("Bases must be at least 2.");
        int lengthOfNumber = number.length;
        for (int i = 0; i < lengthOfNumber; i++) {
            int neededNumber = number[lengthOfNumber - i - 1];
            if (neededNumber >= base)
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            if (neededNumber < 0) throw new IllegalArgumentException("Digits may not be negative.");
            this.value += neededNumber * Math.pow(base, i);
        }
    }

    public List<Integer> convertToBase(int base) {
        if (base < 2) throw new IllegalArgumentException("Bases must be at least 2.");
        if (value == 0) return Arrays.asList(0);
        LinkedList<Integer> result = new LinkedList<>();
        while (value != 0) {
            result.addFirst(value % base);
            value /= base;
        }
        return result;
    }
}
