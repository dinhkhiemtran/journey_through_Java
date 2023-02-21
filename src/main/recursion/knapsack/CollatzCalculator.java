package main.recursion.knapsack;

public class CollatzCalculator {

    private int count;

    public int computeStepCount(int start) {
        if (start < 1) throw new IllegalArgumentException("Only natural numbers are allowed");
        if (start == 1) return count;
        count++;
        return start % 2 == 0 ? computeStepCount(start / 2) : computeStepCount(start * 3 + 1);
    }
}
