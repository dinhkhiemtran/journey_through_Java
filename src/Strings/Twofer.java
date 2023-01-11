package Strings;

public class Twofer {

    public String twofer(String name) {
        if (name == null) name = "you";
        return String.format( "One for %s, one for me.", name);
    }

    public static void main(String[] args) {
        Twofer twofer = new Twofer();
        System.out.println(twofer.twofer("Alice"));
    }
}
