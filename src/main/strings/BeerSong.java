package main.strings;

public class BeerSong {

    public String singSong() {
        return sing(99, 100);
    }

    public String sing(Integer bottleCount, Integer verseCount) {
        String song = "";
        while (verseCount > 0) {
            song += verse(bottleCount);
            bottleCount--;
            verseCount--;
        }
        return song;
    }


    public String verse(Integer bottleCount) {
        Integer bottleMinusOne = bottleCount - 1;
        switch (bottleCount) {
            case 0:
                return "No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
            case 1:
                return "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
            case 2:
                return "2 bottles of beer on the wall, 2 bottles of beer.\n" +
                        "Take one down and pass it around, 1 bottle of beer on the wall.\n\n";
            default:
                return bottleCount.toString() + " bottles of beer on the wall, " + bottleCount.toString() + " bottles of beer.\n" +
                        "Take one down and pass it around, " + bottleMinusOne.toString() + " bottles of beer on the wall.\n\n";
        }
    }

    public static void main(String[] args) {
        BeerSong song = new BeerSong();
        String results = song.singSong();
        System.out.println(results);
    }
}
