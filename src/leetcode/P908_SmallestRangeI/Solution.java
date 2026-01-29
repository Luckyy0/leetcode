package leetcode.P908_SmallestRangeI;

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        return Math.max(0, (max - k) - (min + k));
    }
}
