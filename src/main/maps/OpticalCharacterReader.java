package main.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OpticalCharacterReader {
    private static char[] template = "*_*|_||_|".toCharArray();
    private static Map<Integer, String> mapping = new HashMap<>();

    static {
        mapping.put(0xAF, "0");
        mapping.put(0x09, "1");
        mapping.put(0x9E, "2");
        mapping.put(0x9B, "3");
        mapping.put(0x39, "4");
        mapping.put(0xB3, "5");
        mapping.put(0xB7, "6");
        mapping.put(0x89, "7");
        mapping.put(0xBF, "8");
        mapping.put(0xBB, "9");
    }

    private static Stream<String> getLetters(List<String> input) {
        return IntStream.range(0, input.get(0).length())
                .filter(e -> e % 3 == 0)
                .mapToObj(i -> input.stream()
                        .map(line -> line.substring(i, i + 3))
                        .collect(Collectors.joining("")));
    }

    private static int hasSegment(String letter, int i) {
        return letter.charAt(i) == template[i] ? 1 : 0;
    }

    private static String toChar(int x) {
        return mapping.containsKey(x) ? mapping.get(x) : "?";
    }

    private static int transcode(String letter) {
        return IntStream.range(0, 9)
                .reduce(0, (r, i) -> (r << 1) | hasSegment(letter, i));
    }

    public String parse(List<String> input) {
        if (input.size() % 4 != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (input.get(0).length() % 3 != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }
        return IntStream.range(0, input.size())
                .filter(e -> e % 4 == 0)
                .mapToObj(i -> getLetters(input.subList(i, i + 4))
                        .map(OpticalCharacterReader::transcode)
                        .map(OpticalCharacterReader::toChar)
                        .collect(Collectors.joining("")))
                .collect(Collectors.joining(","));
    }
}
