package leetcode.P1335_MinimumDifficultyOfAJobSchedule;

import java.util.Arrays;

class Solution {
    int[][] memo;
    int n;
    int[] jobs;

    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length;
        if (n < d)
            return -1;

        jobs = jobDifficulty;
        memo = new int[n][d + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);

        return solve(0, d);
    }

    private int solve(int idx, int d) {
        if (d == 1) {
            int max = 0;
            for (int i = idx; i < n; i++)
                max = Math.max(max, jobs[i]);
            return max;
        }

        if (memo[idx][d] != -1)
            return memo[idx][d];

        int max = 0;
        int res = Integer.MAX_VALUE;

        // Try all split points
        // leave at least d-1 jobs for remaining days
        for (int i = idx; i <= n - d; i++) {
            max = Math.max(max, jobs[i]);
            int next = solve(i + 1, d - 1);
            if (next != Integer.MAX_VALUE) {
                res = Math.min(res, max + next);
            }
        }

        return memo[idx][d] = res;
    }
}
