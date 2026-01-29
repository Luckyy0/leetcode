package leetcode.P724_FindPivotIndex;

class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Check condition: leftSum == totalSum - leftSum - nums[i]
            // or: 2 * leftSum == totalSum - nums[i]
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}
