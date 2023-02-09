package main.maps;

import java.util.*;

public class CharacterCount {

    private HashMap<Character, Integer> mapping = new HashMap<>();

    private String str;

    public CharacterCount(String str) {
        this.str = str.replace(" ", "");
    }

    public HashMap<Character, Integer> putElements() {
        int lengthOfString = str.length();
        for (int i = 0; i < lengthOfString; i++) {
            if (mapping.containsKey(str.charAt(i))) {
                mapping.put(str.charAt(i), mapping.get(str.charAt(i)) + 1);
            } else {
                mapping.put(str.charAt(i), 1);
            }
        }
        return mapping;
    }

    public char countingCharacter() {
        HashMap<Character, Integer> mapping = putElements();
        char max = str.charAt(0);
        for (Character key : mapping.keySet()){
            if (mapping.get(key) > mapping.get(max)){
                max = key;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "Welcome to the black parade.";
        CharacterCount count = new CharacterCount(str);
        System.out.println(count.countingCharacter());
    }
}
