package leetcode.P1827_MinimumOperationsToMakeTheArrayIncreasing;

public class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int target = nums[i - 1] + 1;
                ops += target - nums[i];
                nums[i] = target;
            }
        }
        return ops;
    }
}
