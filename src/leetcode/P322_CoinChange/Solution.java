package leetcode.P322_CoinChange;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 322: Coin Change
     * Approach: DP Bottom Up
     * 
     * Time Complexity: O(S * n) where S is amount, n is coin count
     * Space Complexity: O(S)
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,5], 11 -> 3
        runTest(solution, new int[] { 1, 2, 5 }, 11, 3);

        // [2], 3 -> -1
        runTest(solution, new int[] { 2 }, 3, -1);

        // [1], 0 -> 0
        runTest(solution, new int[] { 1 }, 0, 0);
    }

    private static void runTest(Solution s, int[] coins, int amount, int expected) {
        int result = s.coinChange(coins, amount);
        System.out.println("Amount: " + amount + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
