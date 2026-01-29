package leetcode.P1589_MaximumSumObtainedOfAnyPermutation;

import java.util.Arrays;

public class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] freq = new int[n];

        // Difference array to count range overlaps
        for (int[] req : requests) {
            freq[req[0]]++;
            if (req[1] + 1 < n) {
                freq[req[1] + 1]--;
            }
        }

        // Compute actual frequencies
        for (int i = 1; i < n; i++) {
            freq[i] += freq[i - 1];
        }

        // Sort frequencies and nums to match greedy
        Arrays.sort(freq);
        Arrays.sort(nums);

        long totalSum = 0;
        long MOD = 1_000_000_007;

        // Match largest freq with largest num
        for (int i = 0; i < n; i++) {
            if (freq[i] > 0) {
                totalSum = (totalSum + (long) freq[i] * nums[i]) % MOD;
            }
        }

        return (int) totalSum;
    }
}
