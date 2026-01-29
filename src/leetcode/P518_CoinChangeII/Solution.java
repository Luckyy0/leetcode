package leetcode.P518_CoinChangeII;

public class Solution {

    /**
     * Problem 518: Coin Change II
     * Approach: 1D Dynamic Programming (Unbounded Subset Sum)
     * 
     * Time Complexity: O(N * A)
     * Space Complexity: O(A)
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
        Solution sol = new Solution();

        // amount=5, coins=[1,2,5] -> 4
        int[] c1 = { 1, 2, 5 };
        System.out.println("Result 1: " + sol.change(5, c1) + " (Expected: 4)");

        // amount=3, coins=[2] -> 0
        int[] c2 = { 2 };
        System.out.println("Result 2: " + sol.change(3, c2) + " (Expected: 0)");
    }
}
