package leetcode.P301_RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Problem 301: Remove Invalid Parentheses
     * Approach: DFS with limited removals
     * 
     * Theoretical Basis:
     * - First calculate min remove count for '(' and ')' to determine BFS/DFS
     * depth.
     * - DFS to explore states, pruning duplicates and invalid prefixes.
     * 
     * Time Complexity: O(2^N) worst case
     * Space Complexity: O(N)
     */
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0;
        int rightRem = 0;

        // 1. Calculate how many left and right parentheses MUST be removed
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--; // Matches a previous '('
                } else {
                    rightRem++; // Invalid ')'
                }
            }
        }

        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, leftRem, rightRem, 0, 0, sb, result);

        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, int leftRem, int rightRem, int open, int start, StringBuilder sb,
            Set<String> result) {
        // Base case: Reached end of string
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0 && open == 0) {
                result.add(sb.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int len = sb.length();

        if (c == '(') {
            // Option 1: Remove '(' if we still need to remove 'leftRem'
            // Skip invalid removals (consecutive duplicates handled by Set, but can
            // optimize skipping here too)
            if (leftRem > 0) {
                dfs(s, index + 1, leftRem - 1, rightRem, open, start, sb, result);
            }

            // Option 2: Keep '('
            sb.append(c);
            dfs(s, index + 1, leftRem, rightRem, open + 1, start, sb, result);
            sb.setLength(len); // Backtrack

        } else if (c == ')') {
            // Option 1: Remove ')' if we still need to remove 'rightRem'
            if (rightRem > 0) {
                dfs(s, index + 1, leftRem, rightRem - 1, open, start, sb, result);
            }

            // Option 2: Keep ')' ONLY if open > 0 (valid prefix)
            if (open > 0) {
                sb.append(c);
                dfs(s, index + 1, leftRem, rightRem, open - 1, start, sb, result);
                sb.setLength(len); // Backtrack
            }

        } else {
            // Processing letters (always keep)
            sb.append(c);
            dfs(s, index + 1, leftRem, rightRem, open, start, sb, result);
            sb.setLength(len); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "()())()" -> ["(())()", "()()()"]
        runTest(solution, "()())()");

        // "(a)())()" -> ["(a())()", "(a)()()"]
        runTest(solution, "(a)())()");

        // ")(" -> [""]
        runTest(solution, ")(");
    }

    private static void runTest(Solution s, String str) {
        List<String> res = s.removeInvalidParentheses(str);
        System.out.println("Input: \"" + str + "\" -> " + res);
        System.out.println("-----------------");
    }
}
