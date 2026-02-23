package leet_code.Problem_718_Medium_Maximum_Length_of_Repeated_Subarray;

public class Solution {

    /**
     * Finds the maximum length of a common subarray.
     * Strategy: 2D Dynamic Programming (Longest Common Substring logic).
     * Time: O(M * N), Space: O(M * N).
     */
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // dp[i][j] is the length of common suffix of nums1[0..i-1] and nums2[0..j-1]
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    // Elements match, extend the prefix length
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    // Continuity broken, reset to 0
                    dp[i][j] = 0;
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = { 1, 2, 3, 2, 1 };
        int[] n2 = { 3, 2, 1, 4, 7 };
        System.out.println("Result 1: " + sol.findLength(n1, n2)); // 3

        int[] n3 = { 0, 0, 0, 0, 0 };
        int[] n4 = { 0, 0, 0, 0, 0 };
        System.out.println("Result 2: " + sol.findLength(n3, n4)); // 5
    }
}
