package leetcode.P1909_RemoveOneElementToMakeTheArrayStrictlyIncreasing;

public class Solution {
    public boolean canBeIncreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                // Violation found. Must remove i-1 or i.
                return check(nums, i - 1) || check(nums, i);
            }
        }
        return true;
    }

    private boolean check(int[] nums, int removeIdx) {
        int prev = -1;
        // Logic to simulate array traversal skipping removeIdx
        // Start handling first element correctly
        int start = (removeIdx == 0) ? 1 : 0;
        if (start < nums.length)
            prev = nums[start];

        for (int i = start + 1; i < nums.length; i++) {
            if (i == removeIdx)
                continue;
            if (nums[i] <= prev)
                return false;
            prev = nums[i];
        }
        return true;
    }
}
