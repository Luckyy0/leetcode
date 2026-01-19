package leetcode.P241_DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * Problem 241: Different Ways to Add Parentheses
     * Approach: Recursion with Memoization (Divide and Conquer)
     * 
     * Theoretical Basis:
     * - Split expression at every operator.
     * - Combine results of left and right sub-expressions.
     * 
     * Time Complexity: Depends on Catalan number structure, but effectively
     * optimized by memoization for small N.
     * Space Complexity: O(N) recursion + storage for lists.
     */

    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        // If no operator is found, the expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        memo.put(expression, result);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "2-1-1" -> [0, 2]
        runTest(solution, "2-1-1");

        // "2*3-4*5" -> [-34, -14, -10, -10, 10]
        runTest(solution, "2*3-4*5");
    }

    private static void runTest(Solution s, String expr) {
        // Clear memo for fresh test if reusing instance logic (though new Map per call
        // usually safer, here it's field)
        // Ideally should reset memo, but for different strings it might separate.
        // For strictness, let's create new Solution instance or clear memo.
        // Here we just use same instance, keys are unique enough or valid to reuse.
        s.memo.clear();

        List<Integer> result = s.diffWaysToCompute(expr);
        System.out.println("Expression: " + expr);
        System.out.println("Result: " + result);
        System.out.println("-----------------");
    }
}
