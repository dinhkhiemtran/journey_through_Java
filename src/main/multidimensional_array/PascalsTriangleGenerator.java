package main.multidimensional_array;

public class PascalsTriangleGenerator {

    public int[][] generateTriangle(int level) {
        if (level < 0) {
            throw new IllegalArgumentException();
        }
        int[][] retVal = new int[level][];
        for (int i = 0; i < level; i++) {
            retVal[i] = new int[i + 1];
            retVal[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                retVal[i][j] = retVal[i - 1][j - 1] + (j <= i - 1 ? retVal[i - 1][j] : 0);
            }
        }
        return retVal;
    }
}
