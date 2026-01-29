package leetcode.P1879_MinimumXORSumOfTwoArrays;

import java.util.Arrays;

public class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE)
                continue;

            // Current index in nums1 to match is bitCount(mask)
            int i = Integer.bitCount(mask);
            if (i >= n)
                continue;

            // Try matching nums1[i] with any available j in nums2
            for (int j = 0; j < n; j++) {
                if (((mask >> j) & 1) == 0) {
                    int nextMask = mask | (1 << j);
                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + (nums1[i] ^ nums2[j]));
                }
            }
        }

        return dp[(1 << n) - 1];
    }
}
