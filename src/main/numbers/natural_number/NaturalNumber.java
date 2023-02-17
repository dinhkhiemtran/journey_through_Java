package main.numbers.natural_number;

public class NaturalNumber {

    private int number;

    public NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 1; i <= this.number / 2; i++) {
            if (this.number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public Classification getClassification() {
        int sum = getSum();
        if (sum == this.number) {
            return Classification.PERFECT;
        } else if (sum > this.number) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }
}
