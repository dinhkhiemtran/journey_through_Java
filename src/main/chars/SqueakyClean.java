package main.chars;

public class SqueakyClean {

    public static String clean(String identifier) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = identifier.length();
        for (int i = 0; i < length; i++) {
            char ch = identifier.charAt(i);
            if (Character.isSpaceChar(ch)) {
                stringBuilder.append("_");
            } else if (Character.isISOControl(ch)) {
                stringBuilder.append("CTRL");
            } else if (ch == '-') {
                i++;
                if (Character.isDigit(identifier.charAt(i))) {
                    i++;
                    stringBuilder.append(Character.toUpperCase(identifier.charAt(i)));
                } else {
                    stringBuilder.append(Character.toUpperCase(identifier.charAt(i)));
                }
            } else if (Character.isLetter(ch) == false || (ch >= 'α' && ch <= 'ω'))
                stringBuilder.append("");
            else
                stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(SqueakyClean.clean("my   Id"));
        System.out.println(SqueakyClean.clean("my\0Id"));
        System.out.println(SqueakyClean.clean("à-ḃç"));
        System.out.println(SqueakyClean.clean("a1😀2😀3😀b"));
        System.out.println(SqueakyClean.clean("MyΟβιεγτFinder"));
    }
}
