package numbers;

import java.util.stream.IntStream;

public class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.rangeClosed(1, input).sum(), 2);
    }

    public int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input).parallel().map(i -> (int) Math.pow(i, 2)).sum();
    }

    public int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

    public static void main(String[] args) {
        DifferenceOfSquaresCalculator differenceOfSquaresCalculator = new DifferenceOfSquaresCalculator();
        int squareOfSumTo = differenceOfSquaresCalculator.computeSquareOfSumTo(1);
        int sumOfSquaresTo = differenceOfSquaresCalculator.computeSumOfSquaresTo(0);
        System.out.println("Square Of Sum To: " + squareOfSumTo);
        System.out.println("Sum Of Squares To: " + sumOfSquaresTo);
        int input = 100;
        int differenceOfSquares = differenceOfSquaresCalculator.computeDifferenceOfSquares(input);
        System.out.printf("Difference Of Squares has a value of %s: " + differenceOfSquares, input);
    }

}
