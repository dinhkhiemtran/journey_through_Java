package main.maps;

import java.util.LinkedHashMap;

public class TwelveDays {

    private final static LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

    static {
        map.put(1, "On the first day of Christmas my true love gave to me: " +


                "a Partridge in a Pear Tree.\n");


        map.put(2, "On the second day of Christmas my true love gave to me: two Turtle Doves, " +


                "and a Partridge in a Pear Tree.\n");


        map.put(3, "On the third day of Christmas my true love gave to me: three French Hens, " +


                "two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(4, "On the fourth day of Christmas my true love gave to me: four Calling Birds, " +


                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(5, "On the fifth day of Christmas my true love gave to me: five Gold Rings, " +


                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(6, "On the sixth day of Christmas my true love gave to me: six Geese-a-Laying, " +


                "five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +


                "and a Partridge in a Pear Tree.\n");


        map.put(7, "On the seventh day of Christmas my true love gave to me: " +


                "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, three French Hens, " +


                "two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(8, "On the eighth day of Christmas my true love gave to me: eight Maids-a-Milking," +


                " seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +


                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(9, "On the ninth day of Christmas my true love gave to me: nine Ladies Dancing, " +


                "eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, " +


                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(10, "On the tenth day of Christmas my true love gave to me: ten Lords-a-Leaping, " +


                "nine Ladies Dancing, eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, " +


                "five Gold Rings, four Calling Birds, three French Hens, two Turtle Doves, " +


                "and a Partridge in a Pear Tree.\n");


        map.put(11, "On the eleventh day of Christmas my true love gave to me: " +


                "eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, eight Maids-a-Milking, " +


                "seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, four Calling Birds, " +


                "three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");


        map.put(12, "On the twelfth day of Christmas my true love gave to me: " +


                "twelve Drummers Drumming, eleven Pipers Piping, ten Lords-a-Leaping, nine Ladies Dancing, " +


                "eight Maids-a-Milking, seven Swans-a-Swimming, six Geese-a-Laying, five Gold Rings, " +


                "four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree.\n");
    }

    public String verse(int verseNumber) {
        return map.get(verseNumber);
    }

    public String verses(int startVerse, int endVerse) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            stringBuilder.append(verse(i));
            if (i < endVerse) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public String sing() {
        int startVerse = 1;
        int endVerse = 12;
        return verses(startVerse, endVerse);
    }
}
