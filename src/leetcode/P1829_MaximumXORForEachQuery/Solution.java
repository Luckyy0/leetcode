package leetcode.P1829_MaximumXORForEachQuery;

public class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] result = new int[n];
        int currentXor = 0;
        for (int x : nums)
            currentXor ^= x;

        int mask = (1 << maximumBit) - 1;

        for (int i = 0; i < n; i++) {
            // k = (~currentXor) & mask
            // effectively, k makes all bits 1 within mask if possible
            // max val = mask. currentXor ^ k = mask.
            // so k = currentXor ^ mask.
            result[i] = currentXor ^ mask;

            // Remove last element
            currentXor ^= nums[n - 1 - i];
        }

        return result;
    }
}
