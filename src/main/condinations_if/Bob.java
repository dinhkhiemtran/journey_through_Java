package main.condinations_if;

public class Bob {

    public String hey(String phrase) {
        String trimmedPhrase = phrase.trim();
        if (trimmedPhrase.isEmpty()) return "Fine. Be that way!";
        if (isUpper(trimmedPhrase) && trimmedPhrase.endsWith("?")) return "Calm down, I know what I'm doing!";
        if (isUpper(trimmedPhrase)) return "Whoa, chill out!";
        if (trimmedPhrase.endsWith("?")) return "Sure.";
        return "Whatever.";
    }

    public  boolean isUpper(String str) {
        return str.chars().anyMatch(Character::isLetter) && str.equals(str.toUpperCase());
    }

}
