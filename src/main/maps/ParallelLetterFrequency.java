package main.maps;

import java.util.concurrent.ConcurrentHashMap;

public class ParallelLetterFrequency {

    private String inputString;

    private ConcurrentHashMap<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

    public ParallelLetterFrequency(String inputString) {
        this.inputString = inputString.toLowerCase()
                .replaceAll("\\p{Punct}", "")
                .replaceAll("[0-9]", "")
                .replace(" ", "");
    }

    public ConcurrentHashMap<Integer, Integer> letterCounts() {
        for (int i = 0; i < inputString.length(); i++) {
            if (concurrentMap.containsKey((int) inputString.charAt(i))) {
                concurrentMap.computeIfPresent((int) inputString.charAt(i), (k, v) -> v + 1);
            } else {
                concurrentMap.put((int) inputString.charAt(i), 1);
            }
        }
        return concurrentMap;
    }
}
