package leetcode.P1508_RangeSumOfSortedSubarraySums;

import java.util.Arrays;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n * (n + 1) / 2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                sums[idx++] = currentSum;
            }
        }

        Arrays.sort(sums);

        long result = 0;
        int MOD = 1_000_000_007;
        for (int i = left - 1; i < right; i++) {
            result = (result + sums[i]) % MOD;
        }

        return (int) result;
    }
}
