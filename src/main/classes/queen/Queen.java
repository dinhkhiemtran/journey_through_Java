package main.classes.queen;

public class Queen {

    private final String POSITION_LESS_THAN_OR_EQUAL_TO_7_ROW = "Queen position must have row <= 7.";

    private final String POSITION_LESS_THAN_OR_EQUAL_TO_7_COLUMN = "Queen position must have column <= 7.";

    private final String QUEEN_POSITION_HAVE_NO_POSITION_ROW = "Queen position must have positive row.";

    private final String QUEEN_POSITION_HAVE_NO_POSITION_ROW_COLUMN = "Queen position must have positive column.";

    private int row;

    private int column;

    public Queen(int row, int column) {
        if (row >= 0) {
            if (row < 8) {
                this.row = row;
            } else {
                throw new IllegalArgumentException(POSITION_LESS_THAN_OR_EQUAL_TO_7_ROW);
            }
        } else {
            throw new IllegalArgumentException(QUEEN_POSITION_HAVE_NO_POSITION_ROW);
        }
        if (column >= 0) {
            if (column < 8) {
                this.column = column;
            } else {
                throw new IllegalArgumentException(POSITION_LESS_THAN_OR_EQUAL_TO_7_COLUMN);
            }
        } else {
            throw new IllegalArgumentException(QUEEN_POSITION_HAVE_NO_POSITION_ROW_COLUMN);
        }
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object queen) {
        Queen q = (Queen) queen;
        return this.row == q.getRow() && this.column == q.getColumn();
    }
}
