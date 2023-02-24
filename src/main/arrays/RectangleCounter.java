package main.arrays;

import java.util.ArrayList;
import java.util.List;

public class RectangleCounter {

    public int countRectangles(String[] inputGrid) {
        int numberOfRectangles = 0;
        for (int topRow = 0; topRow < inputGrid.length - 1; topRow++) {
            List<Integer> corners = findCorners(inputGrid[topRow]);
            for (int j = 0; j < corners.size() - 1; j++) {
                for (int k = j + 1; k < corners.size(); k++) {
                    int leftSide = corners.get(j);
                    int rightSide = corners.get(k);
                    if (isContiguous(inputGrid[topRow], leftSide, rightSide)) {
                        numberOfRectangles += countRectanglesBelow(inputGrid, topRow, leftSide, rightSide);
                    }
                }
            }
        }
        return numberOfRectangles;
    }

    private int countRectanglesBelow(String[] inputGrid, int topRow, int leftSide, int rightSide) {
        int numberOfRectangles = 0;
        int bottomRow = topRow + 1;
        while (bottomRow < inputGrid.length && isDownward(inputGrid[bottomRow], leftSide) && isDownward(inputGrid[bottomRow], rightSide)) {
            if (isContiguous(inputGrid[bottomRow], leftSide, rightSide)) {
                numberOfRectangles += 1;
            }
            bottomRow++;
        }
        return numberOfRectangles;
    }

    private boolean isDownward(String row, int column) {
        return isCorner(row, column) || row.charAt(column) == '|';
    }

    private boolean isContiguous(String s, Integer leftSide, Integer rightSide) {
        for (int i = leftSide; i < rightSide + 1; i++) {
            if (!(s.charAt(i) == '-' || isCorner(s, i))) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> findCorners(String row) {
        List<Integer> corners = new ArrayList<>();
        for (int i = 0; i < row.length(); i++) {
            if (isCorner(row, i)) {
                corners.add(i);
            }
        }
        return corners;
    }

    private boolean isCorner(String row, int column) {
        return row.charAt(column) == '+';
    }
}
