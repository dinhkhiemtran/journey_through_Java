package main.encode_decode;

public class Atbash {

    public String encode(String input) {
        return String.join(" ", transform(input).split("(?<=\\G.{5})"));
    }

    public String decode(String input) {
        return transform(input);
    }

    private String transform(String input) {
        return input.replaceAll("\\W+", "")
                .toLowerCase()
                .codePoints()
                .map(e -> Character.isAlphabetic(e)
                        ? 2 * ((int) 'a') + 25 - e
                        : e
                )
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        String input = "abc";
        Atbash atbash = new Atbash();
        System.out.println(atbash.transform(input));
    }
}
