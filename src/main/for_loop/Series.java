package main.for_loop;

import java.util.ArrayList;
import java.util.List;

public class Series {

    private static String number;

    public Series(String number) {
        this.number = number;
    }

    public List<String> slices(int digits) {
        List<String> digitsList = new ArrayList<>();
       if (digits > number.length()) throw new IllegalArgumentException("Slice size is too big.");
       if (digits < 1) throw new IllegalArgumentException("Slice size is too small.");
       for (int i = 0; i <= number.length() - digits; i++) {
           digitsList.add(number.substring(i, i + digits));
       }
       return digitsList;
    }

    public static void main(String[] args) {
        String number =  "49142";
        int digits = 3;
        Series series = new Series(number);
        List<String> list = series.slices(digits);
        System.out.println(list);
    }
}
