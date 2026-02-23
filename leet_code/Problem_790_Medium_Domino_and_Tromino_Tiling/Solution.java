package leet_code.Problem_790_Medium_Domino_and_Tromino_Tiling;

public class Solution {

    /**
     * Calculates the number of ways to tile a 2 x n board.
     * Strategy: Dynamic Programming with recurrence f[n] = 2*f[n-1] + f[n-3].
     * Time: O(N), Space: O(N).
     */
    public int numTilings(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        long MOD = 1_000_000_007;

        long[] dp = new long[n + 1];
        // Base cases
        dp[0] = 1; // Conceptually empty board is 1 way
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            // Formula derived from analyzing full and partial states:
            // f[i] = 2*f[i-1] + f[i-3]
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.numTilings(3)); // 5
        System.out.println("Result 2: " + sol.numTilings(1)); // 1
        System.out.println("Result 3: " + sol.numTilings(4)); // 11
    }
}
