package main.classes.queen;

public class QueenAttackCalculator {

    private Queen whileQueen;
    private Queen blackQueen;
    private final String QUEEN_WITHOUT_EXIST = "You must supply valid positions for both Queens.";
    private final String QUEEN_OCCUPY_SAME_POSITION = "Queens cannot occupy the same position.";

    public QueenAttackCalculator(Queen whileQueen, Queen blackQueen) {
        if (whileQueen == null || blackQueen == null) {
            throw new IllegalArgumentException(QUEEN_WITHOUT_EXIST);
        } else if (blackQueen.equals(whileQueen)) {
            throw new IllegalArgumentException(QUEEN_OCCUPY_SAME_POSITION);
        } else {
            this.blackQueen = blackQueen;
            this.whileQueen = whileQueen;
        }
    }

    private boolean areQueensInSameRow() {
        return whileQueen.getRow() == blackQueen.getRow();
    }

    private boolean areQueensInSameColumn() {
        return blackQueen.getColumn() == whileQueen.getColumn();
    }

    private boolean areQueensInSameDiagonal() {
        int rowDiff = Math.abs(whileQueen.getRow() - blackQueen.getRow());
        int colDiff = Math.abs(whileQueen.getColumn() - blackQueen.getColumn());
        return rowDiff == colDiff;
    }

    public boolean canQueensAttackOneAnother() {
        return areQueensInSameRow() || areQueensInSameColumn() || areQueensInSameDiagonal();
    }
}
