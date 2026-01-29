package leetcode.P1509_MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves;

import java.util.Arrays;

class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 4)
            return 0;

        Arrays.sort(nums);
        int n = nums.length;

        int res = Integer.MAX_VALUE;
        // Option 1: Kill 3 largest
        res = Math.min(res, nums[n - 4] - nums[0]);
        // Option 2: Kill 2 largest, 1 smallest
        res = Math.min(res, nums[n - 3] - nums[1]);
        // Option 3: Kill 1 largest, 2 smallest
        res = Math.min(res, nums[n - 2] - nums[2]);
        // Option 4: Kill 3 smallest
        res = Math.min(res, nums[n - 1] - nums[3]);

        return res;
    }
}
