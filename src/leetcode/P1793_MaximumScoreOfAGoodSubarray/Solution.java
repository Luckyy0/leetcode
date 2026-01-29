package leetcode.P1793_MaximumScoreOfAGoodSubarray;

public class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int l = k;
        int r = k;
        int minVal = nums[k];
        int maxScore = minVal;

        while (l > 0 || r < n - 1) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else if (nums[l - 1] > nums[r + 1]) {
                l--;
            } else {
                r++;
            }
            minVal = Math.min(minVal, Math.min(nums[l], nums[r]));
            maxScore = Math.max(maxScore, minVal * (r - l + 1));
        }

        return maxScore;
    }
}
