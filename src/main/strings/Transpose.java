package main.strings;

import java.util.Arrays;

public class Transpose {

    public String transpose(String toTranspose) {
        String[] rows = toTranspose.split("\n");
        int max = Arrays.stream(rows)
                .mapToInt(String::length)
                .max()
                .orElse(0);
        String[] columns = new String[max];
        int last = rows.length;
        for (int i = 0; i < max; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < last; j++) {
                char cell = rows[j].length() > i ? rows[j].charAt(i) : ' ';
                stringBuilder.append(cell);
            }
            columns[i] = stringBuilder.toString();
            while (last > 0 && rows[last - 1].length() <= i + 1) {
                last--;
            }
        }
        return String.join("\n", columns);
    }
}
