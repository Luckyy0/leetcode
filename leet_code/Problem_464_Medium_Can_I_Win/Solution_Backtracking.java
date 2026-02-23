package leet_code.Problem_464_Medium_Can_I_Win;

import java.util.HashMap;
import java.util.Map;

public class Solution_Backtracking {

    /**
     * Determines if the first player can force a win.
     * Strategy: Minimax with bitmask memoization.
     * Time: O(2^N * N), Space: O(2^N).
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // Edge cases
        if (desiredTotal <= 0)
            return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal)
            return false;

        // Memoization map: bitmask -> canWin
        Map<Integer, Boolean> memo = new HashMap<>();
        return help(maxChoosableInteger, desiredTotal, 0, memo);
    }

    private boolean help(int max, int total, int mask, Map<Integer, Boolean> memo) {
        if (memo.containsKey(mask))
            return memo.get(mask);

        for (int i = 1; i <= max; i++) {
            int bit = 1 << (i - 1);
            if ((mask & bit) == 0) {
                // If choosing this number reaches total, or if opponent cannot win after this
                if (i >= total || !help(max, total - i, mask | bit, memo)) {
                    memo.put(mask, true);
                    return true;
                }
            }
        }

        memo.put(mask, false);
        return false;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();
        System.out.println("Result (10, 11): " + solution.canIWin(10, 11)); // false
        System.out.println("Result (10, 0): " + solution.canIWin(10, 0)); // true
    }
}
