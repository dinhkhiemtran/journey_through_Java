package condination_if.black_jack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class BlackJackSolution1 {

    private enum Option {
        STAND("S"),
        HIT("H"),
        SPLIT("P"),
        AUTOMATICALLY_WIN("W");
        private final String code;
        Option(String code) {
            this.code = code;
        }
    }

    public Map<String, Integer> addCardsToMap() {
        Map<String, Integer> card = new HashMap<>();
        card.put("ace", 11);
        card.put("one", 11);
        card.put("two", 11);
        card.put("three", 11);
        card.put("four", 11);
        card.put("five", 11);
        card.put("six", 11);
        card.put("seven", 11);
        card.put("eight", 11);
        card.put("nine", 11);
        card.put("ten", 10);
        card.put("king", 10);
        card.put("queen", 10);
        card.put("jack", 10);
        return card;
    }


    public int parseCard(String card){
        Map<String, Integer> CARD = addCardsToMap();
        if (CARD.containsKey(card)){
            return CARD.get(card);
        } else {
            throw new IllegalArgumentException(String.format("Unknown card '%s'", card));
        }
    }

    public boolean isBlackjack(String card1, String card2) {
        return Stream.of(card1, card2)
                .mapToInt(this::parseCard)
                .sum() == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore){
        if (!isBlackjack){
            return Option.SPLIT.code;
        }

        if (dealerScore < 10){
            return Option.AUTOMATICALLY_WIN.code;
        }
        return Option.STAND.code;
    }

    public String smallHand(int handScore, int dealerScore){
        if (handScore >= 17){
            return Option.STAND.code;
        }
        if (handScore <= 11){
            return Option.HIT.code;
        }
        return dealerScore >= 7 ? Option.HIT.code : Option.STAND.code;
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
        BlackJackSolution1 blackJackSolution1 = new BlackJackSolution1();
        String result = blackJackSolution1.firstTurn("ace", "ace", "ten");
        System.out.println(result);
    }
}

