package main.for_loop;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House {

    private static final String[] PARTS = {"the house that Jack built.", "the malt that lay in ", "the rat that ate ",
            "the cat that killed ", "the dog that worried ", "the cow with the crumpled horn that tossed ",
            "the maiden all forlorn that milked ", "the man all tattered and torn that kissed ",
            "the priest all shaven and shorn that married ", "the rooster that crowed in the morn that woke ",
            "the farmer sowing his corn that kept ", "the horse and the hound and the horn that belonged to "};

    public String verse(int verse) {
        StringBuilder stringBuilder = new StringBuilder("This is ");
        for (int i = verse - 1; i >= 0; i--) {
            stringBuilder.append(PARTS[i]);
        }
        return stringBuilder.toString();
    }

    public String verses(int startVerse, int endVerse) {
        return String.join("\n", IntStream.rangeClosed(startVerse, endVerse)
                .mapToObj(this::verse)
                .collect(Collectors.toList()));
    }

    public String sing() {
        return verses(1, 12);
    }
}
