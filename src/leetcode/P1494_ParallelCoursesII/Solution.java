package leetcode.P1494_ParallelCoursesII;

import java.util.Arrays;

class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] prereq = new int[n];
        for (int[] r : relations) {
            prereq[r[1] - 1] |= (1 << (r[0] - 1));
        }

        int[] dp = new int[1 << n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] > n)
                continue;

            // Find available courses
            int available = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0 && (prereq[i] & mask) == prereq[i]) {
                    available |= (1 << i);
                }
            }

            int count = Integer.bitCount(available);

            if (count <= k) {
                int nextMask = mask | available;
                dp[nextMask] = Math.min(dp[nextMask], dp[mask] + 1);
            } else {
                // Must pick subset of size k
                // Iterate all submasks of available with size k
                for (int sub = available; sub > 0; sub = (sub - 1) & available) {
                    if (Integer.bitCount(sub) == k) {
                        int nextMask = mask | sub;
                        dp[nextMask] = Math.min(dp[nextMask], dp[mask] + 1);
                    }
                }
            }
        }

        return dp[(1 << n) - 1];
    }
}
