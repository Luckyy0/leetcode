package leetcode.P227_BasicCalculatorII;

import java.util.Stack;

public class Solution {

    /**
     * Problem 227: Basic Calculator II
     * Approach: Stack for handling operator precedence (* and /)
     * 
     * Theoretical Basis:
     * - Defer + and - by pushing to stack.
     * - Execute * and / immediately with the top of stack.
     * - Sum stack at the end.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            // Trigger processing if current char is operator or last char
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == n - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = currentChar;
                currentNumber = 0;
            }
        }

        int result = 0;
        for (int num : stack) {
            result += num;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "3+2*2" -> 7
        runTest(solution, "3+2*2", 7);

        // " 3/2 " -> 1
        runTest(solution, " 3/2 ", 1);

        // " 3+5 / 2 " -> 5 (3 + 2)
        runTest(solution, " 3+5 / 2 ", 5);
    }

    private static void runTest(Solution s, String expr, int expected) {
        int result = s.calculate(expr);
        System.out.println("Expr: \"" + expr + "\"");
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
