package leet_code.Problem_740_Medium_Delete_and_Earn;

public class Solution {

    /**
     * Maximizes points by picking values and deleting neighbors.
     * Strategy: Transform to House Robber problem using bucketing.
     * Time: O(N + M), Space: O(M).
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // Find the maximum value to determine bucket size (M <= 10000)
        int maxVal = 0;
        for (int num : nums)
            maxVal = Math.max(maxVal, num);

        // Step 1: Bucket points by value
        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }

        // Step 2: Dynamic Programming (House Robber style)
        // dp[i] = max points considering values up to i
        int prev2 = 0; // Represents dp[i-2]
        int prev1 = 0; // Represents dp[i-1]

        for (int p : points) {
            // New best is current points + best from two steps back,
            // compared with skip current and keep best from one step back.
            int currentBest = Math.max(prev1, prev2 + p);
            prev2 = prev1;
            prev1 = currentBest;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 3, 4, 2 };
        System.out.println("Result 1: " + sol.deleteAndEarn(nums1)); // 6

        int[] nums2 = { 2, 2, 3, 3, 3, 4 };
        System.out.println("Result 2: " + sol.deleteAndEarn(nums2)); // 9
    }
}
