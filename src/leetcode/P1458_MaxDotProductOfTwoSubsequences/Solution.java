package leetcode.P1458_MaxDotProductOfTwoSubsequences;

class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = nums1[i] * nums2[j];

                int prev = (i > 0 && j > 0) ? dp[i - 1][j - 1] : Integer.MIN_VALUE;

                // Option 1: Start new with current pair or extend previous
                int op1 = Math.max(curr, (prev != Integer.MIN_VALUE ? curr + Math.max(0, prev) : curr));

                // Option 2: Skip nums1[i]
                int op2 = (i > 0) ? dp[i - 1][j] : Integer.MIN_VALUE;

                // Option 3: Skip nums2[j]
                int op3 = (j > 0) ? dp[i][j - 1] : Integer.MIN_VALUE;

                dp[i][j] = Math.max(op1, Math.max(op2, op3));
            }
        }

        return dp[n - 1][m - 1];
    }
}
