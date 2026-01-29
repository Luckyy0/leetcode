package leetcode.P2152_MinimumNumberOfLinesToCoverPoints;

import java.util.Arrays;

public class Solution {
    public int minimumLines(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n == 0 ? 0 : 1;

        // DP Array
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n); // Max is n lines
        dp[0] = 0;

        // Optimization: Precompute lines passing through i and j
        // But simpler: In DP transition, pick lowest uncovered bit i.
        // Try pairing with all j > i.
        // Form line mask.
        // New state: mask | line_mask.

        for (int mask = 0; mask < (1 << n) - 1; mask++) {
            if (dp[mask] == n)
                continue; // Unreachable optimization? No, dp initialized to n (worst case)

            // Find first unset bit
            int i = 0;
            while (((mask >> i) & 1) == 1)
                i++;

            // Try to cover i

            // Option 1: i forms a line alone (rest are covered later, or i is last)
            // But we always want to cover as many as possible.
            // Actually, any line covering i must pass through i and some other point j?
            // Or just i if no other point collinear? (Line through a single point is
            // valid).
            // But to minimize, we should extend to j.

            // If only i remains?
            int remaining = 0;
            for (int k = i; k < n; k++) {
                if (((mask >> k) & 1) == 0)
                    remaining++;
            }
            if (remaining == 1) {
                dp[mask | (1 << i)] = Math.min(dp[mask | (1 << i)], dp[mask] + 1);
                continue;
            }

            // Try pairing i with every other available point j
            for (int j = i + 1; j < n; j++) {
                if (((mask >> j) & 1) == 1)
                    continue;

                // Form line i-j
                int lineMask = 0;
                for (int k = 0; k < n; k++) {
                    if (isCollinear(points[i], points[j], points[k])) {
                        lineMask |= (1 << k);
                    }
                }

                dp[mask | lineMask] = Math.min(dp[mask | lineMask], dp[mask] + 1);
            }
        }

        return dp[(1 << n) - 1];
    }

    private boolean isCollinear(int[] p1, int[] p2, int[] p3) {
        // (y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1)
        // (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)
        return (long) (p2[1] - p1[1]) * (p3[0] - p1[0]) == (long) (p3[1] - p1[1]) * (p2[0] - p1[0]);
    }
}
