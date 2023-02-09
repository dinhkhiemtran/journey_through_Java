package main.numbers;

import java.math.BigInteger;

public class Grains {

    private final int SQUARES_ON_CHESSBOARD = 64;

    public BigInteger grainsOnSquare(final int square) {
        if ((square <= 0) || (square > SQUARES_ON_CHESSBOARD)) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        return BigInteger.valueOf(2).pow(square - 1);
    }

    public BigInteger grainsOnBoard() {
        return BigInteger.valueOf(2).pow(SQUARES_ON_CHESSBOARD).subtract(BigInteger.ONE);
    }

    public static void main(String[] args) {
        Grains grains = new Grains();
        BigInteger total = grains.grainsOnBoard();
        System.out.println("Total grains: " + total);
        int index = 15;
        BigInteger numberOfIndex = grains.grainsOnSquare(index);
        System.out.println("Grains: " + numberOfIndex);
    }
}
