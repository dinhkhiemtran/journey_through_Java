package main.encode_decode;

public class AffineCipher {

    public static final int ALPHABET = 26;

    public String encode(String words, int a, int b) {
        checkValidity(a);
        StringBuilder result = new StringBuilder();
        for (char ch : words.toLowerCase()
                .toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                char encoded;
                if (Character.isLetter(ch)) {
                    encoded = (char) ((a * (ch - 'a') + b) % ALPHABET + 'a');
                } else {
                    encoded = ch;
                }
                if (result.length() % 6 == 5) {
                    result.append(' ');
                }
                result.append(encoded);
            }
        }
        return result.toString();
    }

    public String decode(String words, int a, int b) {
        checkValidity(a);
        StringBuilder result = new StringBuilder();
        for (char ch : words.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                char decoded;
                if (Character.isLetter(ch)) {
                    decoded = (char) (multiplyMod(modInverse(a), ((ch - 'a') - b) % ALPHABET + ALPHABET) % ALPHABET + 'a');
                } else {
                    decoded = ch;
                }
                result.append(decoded);
            }
        }
        return result.toString();
    }

    int modInverse(int x) {
        for (int i = 1; ; i++) {
            if (multiplyMod(x, i) == 1) {
                return i;
            }
        }
    }

    int multiplyMod(int x, int y) {
        return x * y % ALPHABET;
    }

    void checkValidity(int a) {
        if (gcd(a, ALPHABET) != 1) {
            throw new IllegalArgumentException("Error: keyA and alphabet size must be coprime.");
        }
    }

    int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
