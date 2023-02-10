package main.strings;

public class MicroBlog {

    private final static int MAX_POST_LENGTH = 5;

    public String truncate(String input) {
        return input.codePoints()
                .limit(MAX_POST_LENGTH)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static void main(String[] args) {
        MicroBlog microBlog = new MicroBlog();
        String word = "Hi";
        String truncated = microBlog.truncate(word);
        System.out.println(truncated);
    }
}
