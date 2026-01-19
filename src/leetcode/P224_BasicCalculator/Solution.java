package leetcode.P224_BasicCalculator;

import java.util.Stack;

public class Solution {

    /**
     * Problem 224: Basic Calculator
     * Approach: Stack for Parentheses
     * 
     * Theoretical Basis:
     * - Handle + and - as sign multipliers (+1, -1).
     * - Push current context (result, sign) to stack on '('.
     * - Restore context on ')'.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int sign = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                int num = 0;
                // Parse the full number
                while (i < n && Character.isDigit(s.charAt(i))) {
                    // Check overflow normally, but constraints say finding int is fine
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // Backtrack one step because the for loop increments i again
                result += sign * num;

            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                // Push current result and sign to stack
                stack.push(result);
                stack.push(sign);
                // Reset for new parenthesis context
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // End of parenthesis
                // Stack has: [..., prevResult, prevSign]
                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + (result * prevSign);
            }
            // Ignored spaces
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "1 + 1" -> 2
        runTest(solution, "1 + 1", 2);

        // " 2-1 + 2 " -> 3
        runTest(solution, " 2-1 + 2 ", 3);

        // "(1+(4+5+2)-3)+(6+8)" -> 23
        runTest(solution, "(1+(4+5+2)-3)+(6+8)", 23);

        // Unary minus: "-2+ 1" -> -1
        runTest(solution, "-2+ 1", -1);
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
