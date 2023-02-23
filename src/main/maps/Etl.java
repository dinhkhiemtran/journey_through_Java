package main.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Etl {

    private static HashMap<Integer, Integer> mapping = new HashMap<>();

    public Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<Integer, List<String>> entry : old.entrySet()) {
            for (int i = 0 ; i < entry.getValue().size(); i++) {
                newMap.put(entry.getValue().get(i).toLowerCase(), entry.getKey());
            }
        }
        return newMap;
//        old.forEach((key, list) -> list.forEach(e -> newMap.put(e.toLowerCase(), key)));
//        return newMap;
    }
}
