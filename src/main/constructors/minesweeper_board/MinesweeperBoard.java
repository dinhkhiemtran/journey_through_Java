package main.constructors.minesweeper_board;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinesweeperBoard {

    private static final char BOMB = '*';

    private int rowSize;

    private int colSize;

    private List<String> inputBoard;

    public MinesweeperBoard(List<String> inputBoard) {
        this.inputBoard = inputBoard;
        if (!inputBoard.isEmpty()) {
            this.rowSize = inputBoard.size();
            this.colSize = inputBoard.get(0).length();
        }
    }

    public List<String> withNumbers() {
        return IntStream.range(0, rowSize)
                .mapToObj(this::rowCheck)
                .collect(Collectors.toList());
    }

    private String rowCheck(int rowIndex) {
        return IntStream.range(0, colSize)
                .mapToObj(col -> getPrintableValue(new Index(rowIndex, col)))
                .collect(Collectors.joining());
    }

    private String getPrintableValue(Index index) {
        if (getTileValue(index.row, index.col) == BOMB) {
            return String.valueOf(BOMB);
        }
        int number = numberOfAdjacentBombs(index);
        return number == 0 ? " " : Integer.toString(number);
    }

    private int numberOfAdjacentBombs(Index index) {
        return (int) IntStream.rangeClosed(index.row - 1, index.row + 1)
                .mapToObj(rowIndex ->
                        IntStream.rangeClosed(index.col - 1, index.col + 1)
                                .filter(colIndex -> colIndex >= 0 && colIndex < colSize && rowIndex >= 0 && rowIndex < rowSize)
                                .mapToObj(colIndex -> new Index(rowIndex, colIndex)))
                .flatMap(in -> in)
                .filter(in -> !in.equals(index))
                .filter(adj -> getTileValue(adj.row, adj.col) == BOMB)
                .count();
    }

    private char getTileValue(int row, int col) {
        return inputBoard.get(row).charAt(col);
    }
}
