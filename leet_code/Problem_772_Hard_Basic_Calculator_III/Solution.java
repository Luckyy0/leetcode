package leet_code.Problem_772_Hard_Basic_Calculator_III;

import java.util.Stack;

public class Solution {

    private int i = 0; // Global index to track position in string

    /**
     * Evaluates a basic arithmetic expression with parentheses.
     * Strategy: Recursion for parentheses, Stack for precedence.
     * Time: O(N), Space: O(N).
     */
    public int calculate(String s) {
        // Reset index for each call if object is reused, though typically new instance
        // per test.
        // Or if calculate is called recursively, we need to be careful.
        // Actually, for LeetCode, we can reset i = 0 in a wrapper if needed,
        // but since this is the entry point and recursion calls the private/same
        // method,
        // let's ensure i is managed correctly.
        // Wait, if I call calculate recursively, i is shared. That's exactly what we
        // want.
        // But for multiple test cases on same object?
        // Let's reset i only if it's the external call. For safety, wrap it.
        // However, standard LC pattern is creating new Solution() or just let it be.
        // Let's assume input s is cleaned or handled properly.
        // To be safe against previous runs:
        i = 0;
        return recursiveCalc(s);
    }

    private int recursiveCalc(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int num = 0;

        while (i < s.length()) {
            char c = s.charAt(i++);

            if (Character.isDigit(c)) {
                // Build number
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                // Recursively solve sub-expression
                num = recursiveCalc(s);
            }

            // If operator, closing parenthesis, or end of string
            // We must process the previous number and operator
            if (i >= s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                if (op == '+') {
                    stack.push(num);
                } else if (op == '-') {
                    stack.push(-num);
                } else if (op == '*') {
                    stack.push(stack.pop() * num);
                } else if (op == '/') {
                    stack.push(stack.pop() / num);
                }

                op = c;
                num = 0;

                // If closing parenthesis, return the sum of the current stack scope
                if (c == ')') {
                    break;
                }
            }
        }

        int result = 0;
        for (int val : stack) {
            result += val;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.calculate("1+1")); // 2
        System.out.println("Result 2: " + sol.calculate("6-4/2")); // 4
        System.out.println("Result 3: " + sol.calculate("2*(5+5*2)/3+(6/2+8)")); // 21
    }
}
