package leetcode.P022_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 22: Generate Parentheses
     * Approach: Backtracking
     * Time Complexity: O(4^n / sqrt(n))
     * Space Complexity: O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 3, List.of("((()))", "(()())", "(())()", "()(())", "()()()"));
        runTest(solution, 1, List.of("()"));
    }

    private static void runTest(Solution s, int n, List<String> expected) {
        System.out.println("Input: n = " + n);
        List<String> result = s.generateParenthesis(n);
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);

        if (result.size() == expected.size() && result.containsAll(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
