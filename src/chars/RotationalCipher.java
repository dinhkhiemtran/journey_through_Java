package chars;

public class RotationalCipher {

    private int shiftKey;

    private final static int NUMBER_LETTERS = 26;

    public RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    public int rot(int ch) {
        if (!Character.isLetter(ch)){
            return ch;
        }
        char first = Character.isUpperCase(ch) ? 'A' : 'a';
        return first + (ch + shiftKey - first) % NUMBER_LETTERS;
    }

    public String rotate(String data) {
        return data.codePoints()
                .mapToObj(this::rot)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    public static void main(String[] args) {
        RotationalCipher rotationalCipher = new RotationalCipher(21);
        System.out.print(rotationalCipher.rotate("Let's eat, Grandma!"));
    }
}
