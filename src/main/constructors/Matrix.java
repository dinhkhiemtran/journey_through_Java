package main.constructors;

import java.util.Arrays;

public class Matrix {

    private int[][] matrix;

    public Matrix(String matrixAsString) {
        matrix = Arrays.stream(matrixAsString.trim().split("\n"))
                .map(row -> Arrays.stream(row.split("\\s"))
                        .mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
    }

    public int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    public int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(row -> row[columnNumber - 1]).toArray();
    }

    public static void main(String[] args) {
        String matrixAsString = "1 2 3 \n4 5 6 \n7 8 9";
        Matrix matrix = new Matrix(matrixAsString);
        int indexRow = 1;
        int indexColumn = 1;
        System.out.println(Arrays.toString(matrix.getRow(indexRow)));
        System.out.println(Arrays.toString(matrix.getColumn(indexColumn)));
    }
}
