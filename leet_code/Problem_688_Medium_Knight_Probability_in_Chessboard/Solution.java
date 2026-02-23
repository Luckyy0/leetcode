package leet_code.Problem_688_Medium_Knight_Probability_in_Chessboard;

public class Solution {

    /**
     * Calculates the probability that a knight remains on an n x n board after k
     * moves.
     * Strategy: Dynamic Programming to track probability density on each cell.
     * Time: O(K * N^2), Space: O(N^2).
     */
    public double knightProbability(int n, int k, int row, int column) {
        // dp[r][c] stores the probability of the knight being at (r, c)
        double[][] dp = new double[n][n];
        dp[row][column] = 1.0;

        // 8 possible knight moves
        int[][] dirs = {
                { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 },
                { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }
        };

        for (int step = 0; step < k; step++) {
            double[][] nextDp = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                nextDp[nr][nc] += dp[r][c] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = nextDp; // Update current state for the next step
        }

        // Sum up probabilities of all cells on the board after k moves
        double result = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result += dp[r][c];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (n=3, k=2): " + sol.knightProbability(3, 2, 0, 0)); // 0.0625
        System.out.println("Result (n=1, k=0): " + sol.knightProbability(1, 0, 0, 0)); // 1.0
    }
}
