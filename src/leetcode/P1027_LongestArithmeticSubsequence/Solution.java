package leetcode.P1027_LongestArithmeticSubsequence;

import java.util.Arrays;

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001]; // Range [-500, 500] -> offset 500 -> [0, 1000]
        int maxLen = 0;

        // Initialize all as 1 is usually implicit by defaulting to 1 during add

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + 500;
                // Default length is 2 (element i and element j) if not extended
                // If extended, it's dp[j][diff] + 1
                int len = (dp[j][diff] == 0) ? 2 : dp[j][diff] + 1;
                dp[i][diff] = len;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
