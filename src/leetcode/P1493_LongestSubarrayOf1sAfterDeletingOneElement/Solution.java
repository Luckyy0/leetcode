package leetcode.P1493_LongestSubarrayOf1sAfterDeletingOneElement;

class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeros = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            // Current window size is right - left + 1.
            // We must delete one element.
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}
