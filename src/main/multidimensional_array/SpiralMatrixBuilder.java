package main.multidimensional_array;

public class SpiralMatrixBuilder {

    public int[][] buildMatrixOfSize(int size) {
        int[][] matrix = new int[size][size];
        int progress = 0;
        for (int x = 0; x < ((size / 2) + (size % 2)); x++) {
            int sideLength = size - (2 * x);
            for (int i = 0; i < sideLength; i++) // TOP
                matrix[x][x + i] = ++progress;
            for (int i = 1; i < sideLength; i++) // RIGHT
                matrix[x + i][x + sideLength - 1] = ++progress;
            for (int i = sideLength - 2; i >= 0; i--) // BOTTOM
                matrix[x + sideLength - 1][x + i] = ++progress;
            for (int i = sideLength - 2; i > 0; i--) // LEFT
                matrix[x + i][x] = ++progress;
        }
        return matrix;
    }

    public void print() {
        int size = 10;
        int[][] matrix = buildMatrixOfSize(size);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpiralMatrixBuilder spiralMatrixBuilder = new SpiralMatrixBuilder();
        spiralMatrixBuilder.print();
    }
}
