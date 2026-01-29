package leetcode.P1947_MaximumCompatibilityScoreSum;

public class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = students.length;
        int n = students[0].length;

        int[][] scores = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int score = 0;
                for (int k = 0; k < n; k++) {
                    if (students[i][k] == mentors[j][k])
                        score++;
                }
                scores[i][j] = score;
            }
        }

        int[] dp = new int[1 << m];
        // Initialize with -1? Or 0 since standard max. 0 is fine.

        for (int mask = 1; mask < (1 << m); mask++) {
            int studentIdx = Integer.bitCount(mask) - 1;
            for (int j = 0; j < m; j++) {
                if (((mask >> j) & 1) == 1) {
                    int prevMask = mask ^ (1 << j);
                    dp[mask] = Math.max(dp[mask], dp[prevMask] + scores[studentIdx][j]);
                }
            }
        }

        return dp[(1 << m) - 1];
    }
}
