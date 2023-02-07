package main.strings;

import static java.util.Optional.ofNullable;

public class Twofer {

    public String twofer(String name) {
        return String.format("One for %s, one for me.", ofNullable(name).orElse("you"));
    }
    public static void main(String[] args) {
        Twofer twofer = new Twofer();
        System.out.println(twofer.twofer("Alice"));
    }
}
