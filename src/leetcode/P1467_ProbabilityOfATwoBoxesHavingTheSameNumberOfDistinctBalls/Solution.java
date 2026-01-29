package leetcode.P1467_ProbabilityOfATwoBoxesHavingTheSameNumberOfDistinctBalls;

class Solution {
    int n;
    int totalBalls;
    double[][] C;
    int[] balls;
    double validWays = 0;
    double totalWays = 0;

    public double getProbability(int[] balls) {
        this.balls = balls;
        this.totalBalls = 0;
        for (int b : balls)
            totalBalls += b;
        this.n = totalBalls / 2;

        // Precompute combinations
        C = new double[totalBalls + 1][totalBalls + 1];
        for (int i = 0; i <= totalBalls; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }

        dfs(0, 0, 0, 0, 1.0);

        return validWays / totalWays;
    }

    private void dfs(int idx, int count1, int dist1, int dist2, double ways) {
        if (count1 > n)
            return; // Prune: Box 1 full
        // Check remaining balls to ensure we CAN fill Box 1 to n? Optional
        // optimization.

        if (idx == balls.length) {
            if (count1 == n) {
                totalWays += ways;
                if (dist1 == dist2) {
                    validWays += ways;
                }
            }
            return;
        }

        // Iterate how many balls of color idx to put in Box 1
        for (int k = 0; k <= balls[idx]; k++) {
            // k in Box 1, balls[idx]-k in Box 2
            int nextDist1 = dist1 + (k > 0 ? 1 : 0);
            int nextDist2 = dist2 + ((balls[idx] - k) > 0 ? 1 : 0);

            dfs(idx + 1, count1 + k, nextDist1, nextDist2, ways * C[balls[idx]][k]);
        }
    }
}
