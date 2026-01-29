package leetcode.P1685_SumOfAbsoluteDifferencesInASortedArray;

public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            // For left part (0 to i-1): sum(nums[i] - nums[j]) = i * nums[i] - leftSum
            int leftContribution = i * nums[i] - leftSum;

            // For right part (i+1 to n-1): sum(nums[j] - nums[i]) = rightSum - (n - 1 - i)
            // * nums[i]
            int rightContribution = rightSum - (n - 1 - i) * nums[i];

            result[i] = leftContribution + rightContribution;

            leftSum += nums[i];
        }

        return result;
    }
}
