package leetcode.P439_TernaryExpressionParser;

import java.util.Stack;

public class Solution {

    /**
     * Problem 439: Ternary Expression Parser
     * Approach: Right-to-Left Scan with Stack
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char curr = expression.charAt(i);

            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop(); // Remove '?'
                char first = stack.pop(); // Result if true
                stack.pop(); // Remove ':'
                char second = stack.pop(); // Result if false

                if (curr == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(curr);
            }
        }

        return String.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "T?2:3" -> "2"
        runTest(sol, "T?2:3", "2");

        // "F?1:T?4:5" -> "4"
        runTest(sol, "F?1:T?4:5", "4");

        // "T?T?F:5:3" -> "F"
        runTest(sol, "T?T?F:5:3", "F");
    }

    private static void runTest(Solution sol, String expr, String expected) {
        String result = sol.parseTernary(expr);
        System.out.println("Expression: " + expr + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
