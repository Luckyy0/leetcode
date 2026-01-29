package leetcode.P1005_MaximizeSumOfArrayAfterKNegations;

import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);

        // 1. Flip negatives
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // 2. If k is odd, flip smallest absolute value
        if (k % 2 == 1) {
            int minIdx = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[minIdx])
                    minIdx = i;
            }
            nums[minIdx] = -nums[minIdx];
        }

        int sum = 0;
        for (int x : nums)
            sum += x;
        return sum;
    }
}
