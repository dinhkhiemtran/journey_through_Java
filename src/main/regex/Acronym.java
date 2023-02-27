package main.regex;

public class Acronym {

    private String phrase;

    public Acronym(String phrase) {
        this.phrase = phrase.trim().toUpperCase();
    }

    public String get() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = phrase.split("[[ ]*|[-]*|[_]*]+");
        for (String word : words) {
            stringBuilder.append(word.charAt(0));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "Tran Dinh Khiem";
        Acronym acronym = new Acronym(str);
        System.out.println(acronym.get());
    }
}
