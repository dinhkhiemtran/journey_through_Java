package main.maps;

import java.util.HashMap;

public class RaindropConverter {

    private final static HashMap<Integer, String> map = new HashMap<>();
    static {
        map.put(3, "Pling");
        map.put(5, "Plang");
        map.put(7, "Plong");
    }

    public String convert(int number) {
        return map.keySet().stream()
                .filter(k -> number % k == 0)
                .map(k -> map.get(k))
                .reduce((accumulator, currentValue) -> accumulator + currentValue)
                .orElse(Integer.toString(number));
    }

    public static void main(String[] args) {
        RaindropConverter raindropConverter = new RaindropConverter();
        String result = raindropConverter.convert(48);
        System.out.println(result);
    }
}
