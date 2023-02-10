package main.strings;

public class Proverb {

    private String[] words;

    private static final String genericPhrase = "For want of a %s the %s was lost.\n";

    private static final String finalPhrase = "And all for the want of a %s.";

   public Proverb(String[] words) {
        this.words = words;
    }

    public String recite() {
        String prover = "";
        for (int i = 0; i < words.length -1; ++i) {
            prover += String.format(genericPhrase, words[i], words[i + 1]);
        }
        if (words.length > 0) {
            prover += String.format(finalPhrase, words[0]);
        }
        return prover;
    }

    public static void main(String[] args) {
        String[] list = new String[]{"nail", "shoe", "horse", "rider", "message", "battle", "kingdom"};
        Proverb proverb = new Proverb(list);
        String results = proverb.recite();
        System.out.println(results);
    }
}
