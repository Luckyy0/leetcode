package leet_code.Problem_474_Medium_Ones_and_Zeroes;

public class Solution_Knapsack {

    /**
     * Finds the largest subset with at most m 0's and n 1's.
     * Strategy: 2D Knapsack Dynamic Programming.
     * Time: O(len * m * n), Space: O(m * n).
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0;
            int ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0')
                    zeros++;
                else
                    ones++;
            }

            // Standard Knapsack reverse iteration
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution_Knapsack solution = new Solution_Knapsack();
        String[] strs = { "10", "0001", "111001", "1", "0" };
        System.out.println("Result: " + solution.findMaxForm(strs, 5, 3)); // 4
    }
}
