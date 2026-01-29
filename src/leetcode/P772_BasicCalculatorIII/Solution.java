package leetcode.P772_BasicCalculatorIII;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                int n = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    n = n * 10 + (s.charAt(++i) - '0');
                }
                nums.push(n);
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(')
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                ops.pop(); // Remove '('
            } else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) {
                    nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty())
            nums.push(eval(ops.pop(), nums.pop(), nums.pop()));
        return nums.pop();
    }

    private int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        return 0;
    }

    private int eval(char op, int b, int a) {
        if (op == '+')
            return a + b;
        if (op == '-')
            return a - b;
        if (op == '*')
            return a * b;
        if (op == '/')
            return a / b;
        return 0;
    }
}
