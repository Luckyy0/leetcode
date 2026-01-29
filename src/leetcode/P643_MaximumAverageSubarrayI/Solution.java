package leetcode.P643_MaximumAverageSubarrayI;

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        long currentSum = 0;

        // Initial window
        // Cửa sổ ban đầu
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        long maxSum = currentSum;

        // Slide window
        // Trượt cửa sổ
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return (double) maxSum / k;
    }
}
