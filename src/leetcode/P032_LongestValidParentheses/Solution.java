package leetcode.P032_LongestValidParentheses;

import java.util.Stack;

public class Solution {

    /**
     * Problem 32: Longest Valid Parentheses
     * Approach: Stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    // Current closing bracket has no match and invalidates the sequence
                    // Push current index as the new base
                    stack.push(i);
                } else {
                    // Valid pair found
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }

    /**
     * Approach: Two Pointers (O(1) Space)
     */
    public int longestValidParenthesesTwoPointers(String s) {
        int left = 0, right = 0, maxLen = 0;

        // Scan Left to Right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        left = right = 0;

        // Scan Right to Left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "(()", 2);
        runTest(solution, ")()())", 4);
        runTest(solution, "", 0);
        runTest(solution, "()(()", 2);
    }

    private static void runTest(Solution s, String input, int expected) {
        System.out.println("Input: \"" + input + "\"");
        int resultStack = s.longestValidParentheses(input);
        int resultTP = s.longestValidParenthesesTwoPointers(input);

        System.out.println("Stack: " + resultStack);
        System.out.println("TwoPtr: " + resultTP + " (Expected: " + expected + ")");

        if (resultStack == expected && resultTP == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
