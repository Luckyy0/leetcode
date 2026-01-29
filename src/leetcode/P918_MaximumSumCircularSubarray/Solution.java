package leetcode.P918_MaximumSumCircularSubarray;

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int x : nums) {
            curMax = Math.max(curMax + x, x);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + x, x);
            minSum = Math.min(minSum, curMin);
            total += x;
        }

        if (maxSum > 0) {
            return Math.max(maxSum, total - minSum);
        } else {
            return maxSum; // If all elements <= 0
        }
    }
}
