package main.numbers;

public class SumOfMultiples {

    private int number;

    private int[] set;

    public SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    public int getSum() {
        int sum = 0;
        for (int i = 0; i < this.number; i++) {
            for (int s : set) {
                if (s != 0 && i % s == 0) {
                    sum += i;
                    break;
                }
            }
        }
        return sum;
    }
}
