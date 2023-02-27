package main.regex;

import java.util.HashSet;

public class PangramChecker {
    public boolean isPangram(String input) {
        HashSet<Integer> set = new HashSet<>();
        for (char ch : input.replaceAll("[^A-Za-z]+", "").toLowerCase().toCharArray()) {
            set.add((int) ch);
        }
        return set.size() == 26;
    }

    public static void main(String[] args) {
        String input = "the 1 quick brown fox jumps over the 2 lazy dogs";
        PangramChecker pangramChecker = new PangramChecker();
        System.out.println(pangramChecker.isPangram(input));
    }
}
