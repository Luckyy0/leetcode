package leetcode.P464_CanIWin;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 464: Can I Win
     * Approach: Recursion with Bitmask Memoization
     * 
     * Time Complexity: O(2^N * N)
     * Space Complexity: O(2^N)
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal)
            return false;
        if (desiredTotal <= 0)
            return true;

        // Memoization map: state (bitmask) -> can first player win from this state
        // Use a Boolean array for faster access than Map
        return solve(0, desiredTotal, maxChoosableInteger, new Boolean[1 << maxChoosableInteger]);
    }

    private boolean solve(int mask, int remainingTotal, int maxInt, Boolean[] memo) {
        if (memo[mask] != null)
            return memo[mask];

        for (int i = 1; i <= maxInt; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                // If picking i reaches total, current player wins
                if (i >= remainingTotal) {
                    return memo[mask] = true;
                }

                // If picking i leads to a state where the next player cannot win, current
                // player wins
                if (!solve(mask | bit, remainingTotal - i, maxInt, memo)) {
                    return memo[mask] = true;
                }
            }
        }

        return memo[mask] = false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 10, 11 -> false
        System.out.println("Result: " + sol.canIWin(10, 11) + " (Expected: false)");

        // 10, 0 -> true
        System.out.println("Result: " + sol.canIWin(10, 0) + " (Expected: true)");

        // 10, 1 -> true
        System.out.println("Result: " + sol.canIWin(10, 1) + " (Expected: true)");
    }
}
