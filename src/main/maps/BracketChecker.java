package main.maps;

import java.util.HashMap;
import java.util.Stack;

public class BracketChecker {

    private String inputString;

    private static HashMap<Character, Character> map = new HashMap<>();
    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    public BracketChecker(String inputString) {
        this.inputString = inputString;
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        String braces = inputString.replaceAll("[^\\[\\]\\{\\}\\(\\)]+", "");
        if (braces.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : braces.toCharArray()) {
            if (!stack.empty() && map.getOrDefault(stack.peek(), ' ') == ch) {
                stack.pop();
                continue;
            }
            stack.push(ch);
        }
        return stack.empty();
    }
}
