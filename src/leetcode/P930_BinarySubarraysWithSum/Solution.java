package leetcode.P930_BinarySubarraysWithSum;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int k) {
        if (k < 0)
            return 0;
        int res = 0, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
}
