package main.maps;

import java.util.LinkedHashMap;

public class ResistorColorDuo {

    private static LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    static {
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);
    }

    public int value(String[] colors) {
        if (colors.length == 0) {
            throw new IllegalArgumentException("No color given.");
        }
        if (colors.length == 1) {
            return map.get(colors[0].toLowerCase());
        }
        return map.get(colors[0].toLowerCase()) * 10
                + map.get(colors[1].toLowerCase());
    }

}
