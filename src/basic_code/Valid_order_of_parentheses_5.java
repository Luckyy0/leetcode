package basic_code;

import java.util.Stack;

public class Valid_order_of_parentheses_5 {

    public static char change(char ch) {
        return switch (ch) {
            case ')' -> '(';
            case '}' ->  '{';
            case ']' -> '[';
            default -> ' ';
        };
    }
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        char top = ' ';
        for (char ch : s.toCharArray()) {
            if (top == change(ch)) {
                st.pop();
                top = st.isEmpty() ? ' ' : st.peek();
                continue;
            }
            st.push(ch);
            top = ch;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(Valid_order_of_parentheses_5.isValid(s));
    }
}
