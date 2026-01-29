package leetcode.P1937_MaximumNumberOfPointsWithCost;

import java.util.Arrays;

public class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] prev = new long[n];

        for (int j = 0; j < n; j++)
            prev[j] = points[0][j];

        for (int i = 1; i < m; i++) {
            long[] curr = new long[n];
            long[] left = new long[n];
            long[] right = new long[n];

            // Left pass: max(prev[k] + k) for k <= j
            long runningMax = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                runningMax = Math.max(runningMax, prev[j] + j);
                left[j] = runningMax;
            }

            // Right pass: max(prev[k] - k) for k >= j
            runningMax = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                runningMax = Math.max(runningMax, prev[j] - j);
                right[j] = runningMax;
            }

            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(left[j] - j, right[j] + j);
            }

            prev = curr;
        }

        long ans = 0;
        for (long val : prev)
            ans = Math.max(ans, val);
        return ans;
    }
}
