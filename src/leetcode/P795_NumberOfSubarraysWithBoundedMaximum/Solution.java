package leetcode.P795_NumberOfSubarraysWithBoundedMaximum;

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countVal(nums, right) - countVal(nums, left - 1);
    }

    private int countVal(int[] nums, int bound) {
        int res = 0;
        int current = 0;
        for (int x : nums) {
            if (x <= bound) {
                current++;
                res += current;
            } else {
                current = 0;
            }
        }
        return res;
    }
}
