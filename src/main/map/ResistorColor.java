package main.map;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class ResistorColor {

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

    public int colorCode(String color) {
        return map.get(color);
    }

    public String[] colors() {
        return map.keySet().toArray(new String[0]);
    }

    public static void main(String[] args) {
        ResistorColor resistorColor = new ResistorColor();
        String[] str = resistorColor.colors();
        System.out.println(Arrays.toString(str));
    }
}
