package main.encode_decode.crypto_square;

public class CryptoSquare {
    private String text;

    public CryptoSquare(String text) {
        text = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        this.text = text;
    }

    public String getCiphertext() {
        PerimeterData pd = new PerimeterData(text);
        String[] square = makeSquare(text, pd);
        return readSquareVertically(square, pd);
    }

    private String readSquareVertically(String[] square, PerimeterData pd) {
        StringBuilder sb = new StringBuilder();
        for (int column = 0; column < pd.getColumn(); column++) {
            for (int row = 0; row < pd.getRow(); row++) {
                sb.append(square[row].charAt(column));
            }
            if (column < pd.getColumn() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String[] makeSquare(String plainText, PerimeterData pd) {
        plainText = pad(plainText, pd.getRow() * pd.getColumn());
        String[] square = new String[pd.getRow()];
        if (pd.getRow() != 0) {
            for (int row = 0; row < pd.getRow(); row++) {
                int startIndex = row * pd.getColumn();
                square[row] = plainText.substring(startIndex, startIndex + pd.getColumn());
            }
        }
        return square;
    }

    private String pad(String string, int paddedLength) {
        if (string.length() > paddedLength) {
            throw new IllegalArgumentException("Length of string cannot be greater than paddedLength");
        }
        if (string.length() == paddedLength) {
            return string;
        }
        StringBuilder paddedString = new StringBuilder(string);
        while (paddedString.length() < paddedLength) {
            paddedString.append(" ");
        }
        return paddedString.toString();
    }
}
