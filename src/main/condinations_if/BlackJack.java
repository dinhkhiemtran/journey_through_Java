package main.condinations_if;

public class BlackJack {

    private final static int BLACK_JACK = 21;

    private final static String STAND = "S";

    private final String HIT = "H";

    private final String SPLIT = "P";

    private final String WIN = "W";

    public static int parseCard(String card) {
        switch (card) {
            case "ace":
                return 11;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            case "ten":
            case "jack":
            case "queen":
            case "king":
                return 10;
            default:
                return 0;
        }
    }

    public static boolean isBlackjack(String card1, String card2) {
        return parseCard(card1) + parseCard(card2) == BLACK_JACK;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if (!isBlackjack) return SPLIT;
        else if (dealerScore < 10) {
            return WIN;
        } else {
            return STAND;
        }
    }

    public String smallHand(int handScore, int dealerScore) {
        if (handScore >= 17) {
            return STAND;
        } else if (handScore <= 11) {
            return HIT;
        } else if (dealerScore >= 7) {
            return HIT;
        } else {
            return STAND;
        }
    }

    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);
        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }

    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();
        String results = blackJack.firstTurn("one", "one", "three");
        System.out.println(results);
    }
}

