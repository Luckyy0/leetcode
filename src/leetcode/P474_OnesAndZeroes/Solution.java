package leetcode.P474_OnesAndZeroes;

public class Solution {

    /**
     * Problem 474: Ones and Zeroes
     * Approach: 2D 0/1 Knapsack DP
     * 
     * Time Complexity: O(L * M * N)
     * Space Complexity: O(M * N)
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0')
                    zeros++;
                else
                    ones++;
            }

            // Bottom-up update in reverse
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ["10","0001","111001","1","0"], 5, 3 -> 4
        String[] s1 = { "10", "0001", "111001", "1", "0" };
        runTest(sol, s1, 5, 3, 4);

        // ["10","0","1"], 1, 1 -> 2
        String[] s2 = { "10", "0", "1" };
        runTest(sol, s2, 1, 1, 2);
    }

    private static void runTest(Solution sol, String[] strs, int m, int n, int expected) {
        int result = sol.findMaxForm(strs, m, n);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
