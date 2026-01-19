package leetcode.P294_FlipGameII;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 294: Flip Game II
     * Approach: Backtracking with Memoization
     * 
     * Theoretical Basis:
     * - Game Theory: Can win if there is a move leading to a losing state for
     * opponent.
     * 
     * Time Complexity: Roughly O(N!!) ? Depends on state space.
     * Space Complexity: O(N) recursion + map
     */

    private Map<String, Boolean> memo = new HashMap<>();

    public boolean canWin(String currentState) {
        if (memo.containsKey(currentState)) {
            return memo.get(currentState);
        }

        char[] chars = currentState.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                // Try move
                chars[i] = '-';
                chars[i + 1] = '-';
                String nextState = new String(chars);

                // If opponent cannot win from next state, I win
                if (!canWin(nextState)) {
                    // Restore and save
                    chars[i] = '+';
                    chars[i + 1] = '+';
                    memo.put(currentState, true);
                    return true;
                }

                // Restore logic for next iteration
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }

        // No move leads to win -> I lose
        memo.put(currentState, false);
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "++++" -> true
        runTest(solution, "++++", true);

        // "+" -> false
        runTest(solution, "+", false);

        // "++" -> true (flip to "--", opponent has no moves)
        runTest(solution, "++", true);
    }

    private static void runTest(Solution s, String str, boolean expected) {
        // Clear memo for fair testing if reusing instance (though memo is valid across
        // calls for same string)
        // Ideally new instance.
        s = new Solution();
        boolean result = s.canWin(str);
        System.out.println("Input: " + str + " -> " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
