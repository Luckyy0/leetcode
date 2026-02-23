package leet_code.Problem_518_Medium_Coin_Change_II;

public class Solution_DP {

    /**
     * Counts combinations to make amount.
     * Strategy: Unbounded Knapsack DP (Outer loop coins, Inner loop amount).
     * Time: O(N * Amount), Space: O(Amount).
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        int[] coins = { 1, 2, 5 };
        System.out.println("Result: " + solution.change(5, coins)); // 4
    }
}
