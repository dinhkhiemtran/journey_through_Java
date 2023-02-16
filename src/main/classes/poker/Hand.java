package main.classes.poker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hand implements Comparable<Hand> {

    private String cards;

    private double strength;

    Hand(String cards) {
        this.cards = cards;
        this.strength = this.calculateStrength();
    }

    private double calculateStrength() {
        List<Card> cardList = Stream.of(this.cards.split(" "))
                .map(Card::new)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        double strength = 0.0;
        double multipler = 0.1;
        Map<Integer, Long> groupedCards = cardList.stream()
                .collect(Collectors.groupingBy(Card::getValue, () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.counting()));
        final List<Integer> kickers = this.getGroups(groupedCards, 1);
        final List<Integer> pairs = this.getGroups(groupedCards, 2);
        final List<Integer> triplets = this.getGroups(groupedCards, 3);
        final List<Integer> squares = this.getGroups(groupedCards, 4);
        final boolean straight = this.isStraight(cardList);
        final boolean flush = this.isFlush(cardList);
        if (straight && flush) {
            strength = 0.8;
        } else if (!squares.isEmpty()) {
            strength = 0.7;
            multipler /= 100.0;
            strength += squares.get(0) * multipler;
        } else if (this.isFull(pairs, triplets)) {
            strength = 0.6;
            multipler /= 100.0;
            strength += triplets.get(0) * multipler;
            multipler /= 100.0;
            strength += pairs.get(0) * multipler;
        } else if (flush) {
            strength = 0.5;
        } else if (straight) {
            strength = 0.4;
        } else if (!triplets.isEmpty()) {
            strength = 0.3;
            multipler /= 100.0;
            strength += triplets.get(0) * multipler;
        } else if (!pairs.isEmpty()) {
            strength = (pairs.size() == 1) ? 0.1 : 0.2;
            for (int value : pairs) {
                multipler /= 100.0;
                strength += value * multipler;
            }
        }
        if (straight && kickers.get(0) == Card.MAX_VALUE) {
            kickers.remove(0);
        }
        for (int value : kickers) {
            multipler /= 100.0;
            strength += value * multipler;
        }
        return strength;
    }

    private List<Integer> getGroups(final Map<Integer, Long> groupedCards, final int count) {
        return groupedCards.entrySet().stream()
                .filter(entry -> entry.getValue() == count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private boolean isStraight(final List<Card> cardList) {
        for (int i = 0; i < cardList.size() - 1; i++) {
            if (cardList.get(i).getValue() != cardList.get(i + 1).getValue() + 1
                    && (i > 0 || cardList.get(i).getValue() != Card.MAX_VALUE || cardList.get(cardList.size() - 1).getValue() != Card.MIN_VALUE)) {
                return false;
            }
        }
        return true;
    }

    private boolean isFlush(final List<Card> cardList) {
        return cardList.stream()
                .map(Card::getSuit)
                .distinct()
                .count() == 1;
    }

    private boolean isFull(final List<Integer> pairs, final List<Integer> triplets) {
        return pairs.size() == 1 && triplets.size() == 1;
    }

    @Override
    public int compareTo(Hand o) {
        return Double.compare(this.strength, o.strength);
    }

    public String getCards() {
        return this.cards;
    }
}
