package leetcode.P282_ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 282: Expression Add Operators
     * Approach: Backtracking
     * 
     * Theoretical Basis:
     * - Handle precedence of multiplication by keeping track of 'previous operand'.
     * 
     * Time Complexity: O(4^N)
     * Space Complexity: O(N)
     */
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;

        dfs(result, num, target, "", 0, 0, 0);
        return result;
    }

    private void dfs(List<String> result, String num, int target, String expr, int start, long eval, long mult) {
        if (start == num.length()) {
            if (eval == target) {
                result.add(expr);
            }
            return;
        }

        for (int i = start; i < num.length(); i++) {
            // Handle leading zeros: if length > 1 and starts with 0, break
            // e.g. "05" is invalid
            if (i != start && num.charAt(start) == '0')
                break;

            long curr = Long.parseLong(num.substring(start, i + 1));

            if (start == 0) {
                // First number, pick it without operator
                dfs(result, num, target, expr + curr, i + 1, curr, curr);
            } else {
                // Add
                dfs(result, num, target, expr + "+" + curr, i + 1, eval + curr, curr);

                // Subtract
                dfs(result, num, target, expr + "-" + curr, i + 1, eval - curr, -curr);

                // Multiply
                // Logic: Undo previous add/sub of 'mult', then add 'mult * curr'
                // e.g. 2 + 3 * 4. eval was 5 (2+3), mult was 3.
                // new eval = 5 - 3 + (3 * 4) = 2 + 12 = 14.
                // new mult = 3 * 4 = 12.
                dfs(result, num, target, expr + "*" + curr, i + 1, eval - mult + (mult * curr), mult * curr);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "123", 6 -> ["1+2+3", "1*2*3"]
        runTest(solution, "123", 6);

        // "232", 8 -> ["2*3+2", "2+3*2"]
        runTest(solution, "232", 8);

        // "105", 5 -> ["1*0+5", "10-5"]
        runTest(solution, "105", 5);
    }

    private static void runTest(Solution s, String num, int target) {
        List<String> result = s.addOperators(num, target);
        System.out.println("Input: " + num + ", Target: " + target + " -> " + result);
        System.out.println("-----------------");
    }
}
