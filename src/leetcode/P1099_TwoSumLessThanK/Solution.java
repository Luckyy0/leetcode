package leetcode.P1099_TwoSumLessThanK;

import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int maxSum = -1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                maxSum = Math.max(maxSum, sum);
                left++;
            } else {
                right--;
            }
        }

        return maxSum;
    }
}
