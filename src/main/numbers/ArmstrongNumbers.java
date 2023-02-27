package main.numbers;

import java.util.Arrays;

public class ArmstrongNumbers {
    public boolean isArmstrongNumber(int numberToCheck) {
        String[] numberSplit = Integer.toString(numberToCheck).split("");
        int[] convertArray = new int[numberSplit.length];
        int lengthOfArray = numberSplit.length;
        for (int i = 0 ; i < numberSplit.length; i++) {
            convertArray[i] = Integer.parseInt(numberSplit[i]);
        }
        int sum = Arrays.stream(convertArray).reduce(0, (accumulator, currentValue) -> (int) (accumulator + Math.pow(currentValue, lengthOfArray)));
        return sum == numberToCheck;
    }
}
