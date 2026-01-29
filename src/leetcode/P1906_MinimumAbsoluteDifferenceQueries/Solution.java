package leetcode.P1906_MinimumAbsoluteDifferenceQueries;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n = nums.length;
        int[][] prefix = new int[n + 1][101];

        for (int i = 0; i < n; i++) {
            for (int v = 1; v <= 100; v++) {
                prefix[i + 1][v] = prefix[i][v];
            }
            prefix[i + 1][nums[i]]++;
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int minDiff = Integer.MAX_VALUE;
            int prev = -1;

            for (int v = 1; v <= 100; v++) {
                int count = prefix[r + 1][v] - prefix[l][v];
                if (count > 0) {
                    if (prev != -1) {
                        minDiff = Math.min(minDiff, v - prev);
                    }
                    prev = v;
                }
            }

            result[i] = (minDiff == Integer.MAX_VALUE) ? -1 : minDiff;
        }

        return result;
    }
}
