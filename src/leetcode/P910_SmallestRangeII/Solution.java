package leetcode.P910_SmallestRangeII;

import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = nums[n - 1] - nums[0];

        for (int i = 0; i < n - 1; i++) {
            int high = Math.max(nums[i] + k, nums[n - 1] - k);
            int low = Math.min(nums[0] + k, nums[i + 1] - k);
            res = Math.min(res, high - low);
        }

        return res;
    }
}
