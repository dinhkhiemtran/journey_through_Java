package main.chars;

import java.util.HashMap;

public class RnaTranscription {

    private static HashMap<Character, Character> mapping = new HashMap<>();
    static {
        mapping.put('G','C');
        mapping.put('C','G');
        mapping.put('T','A');
        mapping.put('A','U');
    }

    public String transcribe(String dnaStrand) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : dnaStrand.toCharArray()) {
            Character ch = mapping.get(c);
            if (ch != null) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}
