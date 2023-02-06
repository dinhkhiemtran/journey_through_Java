package strings;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : input.toLowerCase().split("\\s+|,")){
            word = word.replaceAll("^\\p{Punct}+|\\p{Punct}+$", "");
            if (word.length() == 0) {
                continue;
            }
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String str ="That's the password: 'PASSWORD 123'!, cried the Special Agent.\nSo I fled.";
        WordCount count = new WordCount();
        Map<String, Integer> results = count.phrase(str);
        System.out.println(results);
    }
}
