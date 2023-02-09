package main.maps;

import java.util.HashMap;

public class Scrabble {

    private String word;

    private static HashMap<Integer, Integer> listScore = new HashMap<>();

    static {
        "AEIOULNRST".chars().forEach(c -> listScore.put(c, 1));
        "DG".chars().forEach(c -> listScore.put(c, 2));
        "BCMP".chars().forEach(c -> listScore.put(c, 3));
        "FHVWY".chars().forEach(c -> listScore.put(c, 4));
        "K".chars().forEach(c -> listScore.put(c, 5));
        "JX".chars().forEach(c -> listScore.put(c, 8));
        "QZ".chars().forEach(c -> listScore.put(c, 10));
    }

    public Scrabble(String word) {

        this.word = word.trim().toUpperCase().replace(" ", "");
    }

    public int getScore() {
        return word.chars().reduce(0, (accumulator, currentValue) -> accumulator + listScore.get(currentValue));
    }

    public static void main(String[] args) {
        Scrabble scrabble = new Scrabble("CAABBGE");
        int result = scrabble.getScore();
        System.out.println(result);
    }
}
