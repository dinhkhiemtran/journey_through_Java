package main.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class NucleotideCounter {

    private static LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    public NucleotideCounter(String dna) {
        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
        dna.chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .forEach(c -> map.put(c, count(c) + 1));
    }

    public LinkedHashMap<Character, Integer> nucleotideCounts() {
        return map;
    }

    public int count(Character nucleotide) {
        if (!map.containsKey(nucleotide)) throw new IllegalArgumentException("Invalid nucleotide: " + nucleotide);
        return map.get(nucleotide);
    }

    public static void main(String[] args) {
        String dna = "GATTACA";
        NucleotideCounter nucleotideCounter = new NucleotideCounter(dna);
        Map<Character, Integer> countingNucleotide = nucleotideCounter.nucleotideCounts();
        System.out.println(countingNucleotide);
    }
}
