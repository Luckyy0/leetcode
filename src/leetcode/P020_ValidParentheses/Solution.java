package leetcode.P020_ValidParentheses;

import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    /**
     * Problem 20: Valid Parentheses
     * Approach: Stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                // Closing bracket
                if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                    return false;
                }
            } else {
                // Opening bracket
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "()", true);
        runTest(solution, "()[]{}", true);
        runTest(solution, "(]", false);
        runTest(solution, "([)]", false);
        runTest(solution, "{[]}", true);
        runTest(solution, "[", false);
        runTest(solution, "]", false);
    }

    private static void runTest(Solution s, String input, boolean expected) {
        System.out.println("Input: \"" + input + "\"");
        boolean result = s.isValid(input);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
