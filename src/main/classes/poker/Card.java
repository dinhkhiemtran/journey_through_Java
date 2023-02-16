package main.classes.poker;

public class Card implements Comparable<Card> {

    public static final int MIN_VALUE = 1;

    public static final int MAX_VALUE = 13;

    private String suit;

    private int value;

    public Card(final String code) {
        this.value = this.calculateValue(code.substring(0, code.length() - 1));
        this.suit = code.substring(code.length() - 1);
    }

    public int getValue() {
        return this.value;
    }

    public String getSuit() {
        return suit;
    }

    private int calculateValue(String value) {
        if (value.matches("\\d+")) {
            return Integer.parseInt(value) - 1;
        } else {
            switch (value) {
                case "J":
                    return 10;
                case "Q":
                    return 11;
                case "K":
                    return 12;
                case "A":
                    return MAX_VALUE;
                default:
                    throw new IllegalArgumentException("Card value not valid!");
            }
        }
    }

    @Override
    public int compareTo(final Card other) {
        return Integer.compare(this.value, other.value);
    }
}