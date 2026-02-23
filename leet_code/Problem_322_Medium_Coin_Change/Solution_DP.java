package leet_code.Problem_322_Medium_Coin_Change;

import java.util.Arrays;

public class Solution_DP {

    /**
     * Finds few coins for amount.
     * Uses Dynamic Programming (Bottom-Up).
     * Time: O(Amount * N), Space: O(Amount).
     * 
     * Tìm số lượng xu ít nhất cho số tiền.
     * Sử dụng Quy hoạch động (Từ dưới lên).
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    if (dp[i - coin] != max) { // Avoid overflow if using MAX_VALUE
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1,2,5], 11 -> 3
        int[] c1 = { 1, 2, 5 };
        System.out.println("Result 1: " + solution.coinChange(c1, 11));

        // Test Case 2: [2], 3 -> -1
        int[] c2 = { 2 };
        System.out.println("Result 2: " + solution.coinChange(c2, 3));

        // Test Case 3: [1], 0 -> 0
        int[] c3 = { 1 };
        System.out.println("Result 3: " + solution.coinChange(c3, 0));
    }
}
