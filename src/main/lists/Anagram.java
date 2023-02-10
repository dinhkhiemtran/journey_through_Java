package main.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    private String word;

    private char[] sorted;

    public Anagram(String word) {
        this.word = word.toLowerCase();
        this.sorted = this.word.toCharArray();
        Arrays.sort(this.sorted);
    }

    public List<String> match(List<String> words) {
        List<String> anagrams = new ArrayList<>();
        for (String word : words) {
            if (isAnagramOf(word)) {
                anagrams.add(word);
            }
        }
        return anagrams;
    }

    private boolean isAnagramOf(String word) {
        if (this.word.length() != word.length()) {
            return false;
        }
        String lowered = word.toLowerCase();
        if (this.word.equals(lowered)) {
            return false;
        }
        char[] sorted = lowered.toCharArray();
        Arrays.sort(sorted);
        return Arrays.equals(this.sorted, sorted);
    }

}
