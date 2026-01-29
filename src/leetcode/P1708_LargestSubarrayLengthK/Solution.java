package leetcode.P1708_LargestSubarrayLengthK;

import java.util.Arrays;

public class Solution {
    public int[] largestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxIndex = 0;
        // Search range [0, n - k]
        for (int i = 1; i <= n - k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return Arrays.copyOfRange(nums, maxIndex, maxIndex + k);
    }
}
