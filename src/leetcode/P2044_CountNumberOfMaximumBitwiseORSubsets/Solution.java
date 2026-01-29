package leetcode.P2044_CountNumberOfMaximumBitwiseORSubsets;

public class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int x : nums)
            maxOr |= x;

        return count(nums, 0, 0, maxOr);
    }

    private int count(int[] nums, int idx, int currentOr, int targetOr) {
        if (idx == nums.length) {
            return currentOr == targetOr ? 1 : 0;
        }

        // Include
        int with = count(nums, idx + 1, currentOr | nums[idx], targetOr);
        // Exclude
        int without = count(nums, idx + 1, currentOr, targetOr);

        return with + without;
    }
}
