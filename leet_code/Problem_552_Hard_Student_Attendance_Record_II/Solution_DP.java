package leet_code.Problem_552_Hard_Student_Attendance_Record_II;

public class Solution_DP {

    private static final int MOD = 1_000_000_007;

    /**
     * Counts the number of eligible attendance records of length n.
     * Strategy: Dynamic Programming with state (A_count, trailing_L_count).
     * Time: O(N), Space: O(1) (after optimization).
     */
    public int checkRecord(int n) {
        // dp[A][L] represents counts with A 'A's and L trailing 'L's
        long[][] dp = new long[2][3];

        // Base case: length 0
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            long[][] nextDp = new long[2][3];

            // 1. Add 'P'
            // Resets trailing 'L' count to 0. A count remains same.
            nextDp[0][0] = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            nextDp[1][0] = (dp[1][0] + dp[1][1] + dp[1][2]) % MOD;

            // 2. Add 'L'
            // Increments trailing 'L' count. A count remains same.
            // Current L must be 0 or 1.
            nextDp[0][1] = dp[0][0];
            nextDp[0][2] = dp[0][1];
            nextDp[1][1] = dp[1][0];
            nextDp[1][2] = dp[1][1];

            // 3. Add 'A'
            // Only possible if current A count is 0.
            // Becomes part of A count 1, resets trailing 'L' count to 0.
            long sumA0 = (dp[0][0] + dp[0][1] + dp[0][2]) % MOD;
            nextDp[1][0] = (nextDp[1][0] + sumA0) % MOD;

            dp = nextDp;
        }

        long total = 0;
        for (int a = 0; a < 2; a++) {
            for (int l = 0; l < 3; l++) {
                total = (total + dp[a][l]) % MOD;
            }
        }

        return (int) total;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        System.out.println("Result n=2: " + solution.checkRecord(2)); // 8
        System.out.println("Result n=1: " + solution.checkRecord(1)); // 3
        System.out.println("Result n=10101: " + solution.checkRecord(10101)); // 183236314
    }
}
