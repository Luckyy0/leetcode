package leetcode.P1140_StoneGameII;

class Solution {
    int[] suffixSum;
    int[][] memo;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        memo = new int[n][n + 1]; // M can go up to N

        return solve(0, 1);
    }

    private int solve(int i, int m) {
        if (i >= n)
            return 0;

        // If we can take all remaining stones
        if (i + 2 * m >= n) {
            return suffixSum[i];
        }

        if (memo[i][m] != 0)
            return memo[i][m];

        int maxStones = 0;

        for (int x = 1; x <= 2 * m; x++) {
            // Opponent's best score from next state
            int opponentScore = solve(i + x, Math.max(m, x));
            // My score is Total - Opponent's best
            int myScore = suffixSum[i] - opponentScore;
            maxStones = Math.max(maxStones, myScore);
        }

        memo[i][m] = maxStones;
        return maxStones;
    }
}
