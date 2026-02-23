package leet_code.Problem_375_Medium_Guess_Number_Higher_or_Lower_II;

public class Solution_DP {

    /**
     * Finds minimum money to guarantee a win.
     * Uses Interval DP (Minimax).
     * Time: O(N^3), Space: O(N^2).
     * 
     * Tìm số tiền tối thiểu để đảm bảo chiến thắng.
     * Sử dụng DP trên khoảng (Minimax).
     */
    public int getAmountToWin(int n) {
        int[][] dp = new int[n + 2][n + 2];

        // length is the size of the range
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                int minWorstCase = Integer.MAX_VALUE;

                // try all guesses k in range [start, end]
                for (int k = start; k <= end; k++) {
                    int cost = k + Math.max(dp[start][k - 1], dp[k + 1][end]);
                    minWorstCase = Math.min(minWorstCase, cost);
                }

                dp[start][end] = minWorstCase;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: n = 10 -> 16
        System.out.println("n = 10: " + solution.getAmountToWin(10));

        // Test Case 2: n = 1 -> 0
        System.out.println("n = 1: " + solution.getAmountToWin(1));
    }
}
