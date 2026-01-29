package leetcode.P1799_MaximizeScoreAfterNOperations;

import java.util.Arrays;

public class Solution {
    private int[][] gcdCache;
    private int[] memo;

    public int maxScore(int[] nums) {
        int n = nums.length;
        gcdCache = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                gcdCache[i][j] = gcd(nums[i], nums[j]);
            }
        }

        memo = new int[1 << n];
        Arrays.fill(memo, -1);

        return solve(0, 1, nums);
    }

    private int solve(int mask, int op, int[] nums) {
        if (op > nums.length / 2)
            return 0;
        if (memo[mask] != -1)
            return memo[mask];

        int maxScore = 0;
        int n = nums.length;

        // Pick two unset bits
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0)
                continue;
            for (int j = i + 1; j < n; j++) { // Use symmetry, strict order
                if ((mask & (1 << j)) != 0)
                    continue;

                int currentGcd = gcdCache[i][j];
                int newMask = mask | (1 << i) | (1 << j);
                int score = op * currentGcd + solve(newMask, op + 1, nums);
                maxScore = Math.max(maxScore, score);
            }
        }

        return memo[mask] = maxScore;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
