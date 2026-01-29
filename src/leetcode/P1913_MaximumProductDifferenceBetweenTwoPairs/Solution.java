package leetcode.P1913_MaximumProductDifferenceBetweenTwoPairs;

import java.util.Arrays;

public class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] * nums[n - 2]) - (nums[0] * nums[1]);
    }
}
