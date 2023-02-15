package main.switch_statements.yacht;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yacht {

    private YachtCategory yachtCategory;
    private List<Integer> dice;

    public Yacht(int[] dice, YachtCategory yachtCategory) {
        this.yachtCategory = yachtCategory;
        this.dice = new ArrayList<>();
        for (int i = 0; i < dice.length; i++) {
            this.dice.add(dice[i]);
        }
    }

    public int score() {
        switch (this.yachtCategory) {
            case YACHT:
                return this.dice.stream()
                        .allMatch(this.dice.get(0)::equals) ? 50 : 0;
            case ONES:
                return (int) this.dice.stream()
                        .filter(element -> element == 1).count();
            case TWOS:
                return (int) (this.dice.stream()
                        .filter(element -> element == 2).count() * 2);
            case THREES:
                return (int) (this.dice.stream()
                        .filter(element -> element == 3).count() * 3);
            case FOURS:
                return (int) (this.dice.stream()
                        .filter(element -> element == 4).count() * 4);
            case FIVES:
                return (int) (this.dice.stream()
                        .filter(element -> element == 5).count() * 5);
            case SIXES:
                return (int) (this.dice.stream()
                        .filter(element -> element == 6).count() * 6);
            case FULL_HOUSE:
                return this.dice.stream()
                        .distinct()
                        .count() == 2 && this.dice.stream()
                        .allMatch(n -> Collections.frequency(this.dice, n) >= 2) ? this.dice.stream().mapToInt(n -> n).sum() : 0;
            case FOUR_OF_A_KIND:
                return this.dice.stream()
                        .filter(n -> (Collections.frequency(this.dice, n) >= 4))
                        .limit(4).mapToInt(n -> n)
                        .sum();
            case LITTLE_STRAIGHT:
                return this.dice.stream()
                        .mapToInt(n -> n)
                        .sum() == 15 && this.dice.stream().distinct().count() == 5 ? 30 : 0;
            case BIG_STRAIGHT:
                return this.dice.stream()
                        .mapToInt(n -> n)
                        .sum() == 20 && this.dice.stream()
                            .distinct()
                        .count() == 5 ? 30 : 0;
            default:
                return this.dice.stream().mapToInt(n -> n).sum();
        }
    }

}
