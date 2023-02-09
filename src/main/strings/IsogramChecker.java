package main.strings;

public class IsogramChecker {

    public boolean isIsogram(String phrase) {
        phrase = phrase.replace(" ","").replace("-", "");
        return phrase.replace("-", "").toLowerCase().chars()
                .distinct()
                .count() == phrase.length();
    }

    public static void main(String[] args) {
        String phrase = "Emily Jung Schwartzkopf";
        IsogramChecker isogramChecker = new IsogramChecker();
        boolean isIsogram = isogramChecker.isIsogram(phrase);
        System.out.println(isIsogram);
    }
}
