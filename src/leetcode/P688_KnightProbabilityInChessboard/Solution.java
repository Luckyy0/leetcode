package leetcode.P688_KnightProbabilityInChessboard;

class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        double[][] dp = new double[n][n];
        int[][] dirs = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

        dp[row][column] = 1.0;

        for (int step = 0; step < k; step++) {
            double[][] nextDp = new double[n][n];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (dp[r][c] > 0) {
                        for (int[] dir : dirs) {
                            int nr = r + dir[0];
                            int nc = c + dir[1];
                            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                                nextDp[nr][nc] += dp[r][c] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = nextDp;
        }

        double totalProb = 0;
        for (double[] r : dp) {
            for (double prob : r) {
                totalProb += prob;
            }
        }
        return totalProb;
    }
}
