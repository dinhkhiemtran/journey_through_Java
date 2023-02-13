package main.strings;

import java.util.LinkedHashMap;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

public class FoodChain {
    private final class Description {
        private String creature;
        private String reason;
        private String connection;

        public Description(String creature, String reason, String connection) {
            this.creature = creature;
            this.reason = reason;
            this.connection = connection;
        }

        public String getCreature() {
            return this.creature;
        }

        public void setCreature(String creature) {
            this.creature = creature;
        }

        public String getReason() {
            return this.reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getConnection() {
            return this.connection;
        }

        public void setConnection(String connection) {
            this.connection = connection;
        }

    }

    private static final String START = "I know an old lady who swallowed a %s.\n";

    private static LinkedHashMap<Integer, Description> map = new LinkedHashMap<>();

    {
        map.put(1, new Description("fly",
                "I don't know why she swallowed the fly. Perhaps she'll die.",
                ""));
        map.put(2, new Description("spider",
                "She swallowed the spider to catch the fly.",
                "It wriggled and jiggled and tickled inside her."));
        map.put(3, new Description("bird",
                "She swallowed the bird to catch the spider that wriggled and jiggled and tickled inside her.",
                "How absurd to swallow a bird!"));
        map.put(4, new Description("cat",
                "She swallowed the cat to catch the bird.",
                "Imagine that, to swallow a cat!"));
        map.put(5, new Description("dog",
                "She swallowed the dog to catch the cat.",
                "What a hog, to swallow a dog!"));
        map.put(6, new Description("goat",
                "She swallowed the goat to catch the dog.",
                "Just opened her throat and swallowed a goat!"));
        map.put(7, new Description("cow",
                "She swallowed the cow to catch the goat.",
                "I don't know how she swallowed a cow!"));
        map.put(8, new Description("horse",
                "She's dead, of course!",
                ""));
    }

    public String verse(int start) {
        Description description = map.get(start);
        String intro = String.format(START, description.getCreature());
        if (start == map.keySet()
                .stream()
                .findFirst()
                .get() || start == map.size()) {
            return intro + description.getReason();

        }
        return intro + range(0, start)
                .map(i -> start - i)
                .mapToObj(i -> {
                    Description currentDescription = map.get(i);
                    String reason = currentDescription.getReason();
                    return i == start ? currentDescription.getConnection()
                            .concat("\n")
                            .concat(reason) : reason;
                })
                .collect(joining("\n"));
    }


    public String verses(int start, int end) {
        return range(start, end + 1).mapToObj(i -> verse(i))
                .collect(joining("\n\n"));
    }
}


