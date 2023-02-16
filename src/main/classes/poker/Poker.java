package main.classes.poker;

import java.util.List;
import java.util.stream.Collectors;

public class Poker {
    final List<String> bestHands;

    public Poker(List<String> hands) {
        List<Hand> handList = hands.stream()
                .map(Hand::new)
                .collect(Collectors.toList());
        Hand highestRank = handList.stream()
                .max(Hand::compareTo)
                .orElseThrow(IllegalArgumentException::new);
        this.bestHands = handList.stream()
                .filter(hand -> hand.compareTo(highestRank) == 0)
                .map(Hand::getCards)
                .collect(Collectors.toList());
    }

    public List<String> getBestHands() {
        return this.bestHands;
    }
}
