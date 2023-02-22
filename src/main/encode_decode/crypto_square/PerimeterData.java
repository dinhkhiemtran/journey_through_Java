package main.encode_decode.crypto_square;

public class PerimeterData {
    private final String plainText;

    private int row = 0;

    private int column = 0;

    PerimeterData(String plainText) {
        this.plainText = plainText;
        if (!plainText.isEmpty()) {
            determineColumnAndRow();
        }
    }

    final void determineColumnAndRow() {
        do {
            column++;
            row = (int) Math.ceil((double) plainText.length() / column);
        } while (column < row || column - row > 1);
    }

    int getRow() {
        return row;
    }

    int getColumn() {
        return column;
    }
}
