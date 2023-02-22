package main.encode_decode;

import java.util.stream.IntStream;

import java.util.stream.Stream;

import java.util.function.*;

import java.lang.IllegalArgumentException;

import java.util.Random;

public class Cipher {

    String key;

    public Cipher() {
        this.key = randomKey();
    }

    public Cipher(String key) {
        if (key == null || key.isEmpty() || !isLegalKey(key)) {
            throw new IllegalArgumentException();
        }
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String encode(String message) {
        return process(message, (m, k) -> m + k);
    }

    public String decode(String message) {
        return process(message, (m, k) -> m - k);
    }

    public String process(String message, IntBinaryOperator f) {
        IntUnaryOperator applyCipher = i -> {
            int messageBase = toBase(message.charAt(i));
            int keyBase = toBase(key.charAt(i % key.length()));
            int result = f.applyAsInt(messageBase, keyBase);
            return wrap(result);
        };
        return IntStream.range(0, message.length())
                .map(applyCipher)
                .mapToObj(c -> "" + (char) c)
                .reduce("", String::concat);
    }

    private static int toBase(char i) {
        return (int) i - (int) 'a';
    }

    private static int wrap(int i) {
        return ((i + 26) % 26) + (int) 'a';
    }

    private static boolean isLegalKey(String s) {
        return s.chars().allMatch(Character::isLowerCase);
    }

    private static String randomKey() {
        Random gen = new Random();
        StringBuilder result = new StringBuilder();
        final int min = 'a';
        final int max = 'z';
        for (int i = 0; i < 100; i++) {
            int cur = gen.nextInt(max - min) + min;
            result.append((char) cur);
        }
        return result.toString();
    }
}