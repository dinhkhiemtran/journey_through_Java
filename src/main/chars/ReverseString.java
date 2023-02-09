package main.chars;

import java.util.Stack;

public class ReverseString {

    public String reverse(String inputString) {
        Stack<Character> stack = new Stack<>();
        char[] reverseString = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }
        for (int i = 0; i < reverseString.length; i++) {
            reverseString[i] = stack.pop();
        }
        return new String(reverseString);
    }
}
