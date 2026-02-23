package leet_code.Problem_486_Medium_Predict_the_Winner;

public class Solution_Minimax {

    /**
     * Determines if Player 1 can win.
     * Strategy: DP Minimax. Maximize score difference (P1 - P2).
     * Time: O(N^2), Space: O(N).
     */
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i] will store the max score difference for subarray ending at i (or
        // starting at i in 1D optimization)
        // Let's use 2D first for clarity, then explain 1D logic if needed.
        // With N=20, 2D is perfectly fine.

        int[][] dp = new int[n][n];

        // Base case: length 1 subarrays
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Iterate over lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // Transition: Maximize (Current Choice - Opponent's Best form Remaining)
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] >= 0;
    }

    // Space Optimization O(N)
    public boolean predictTheWinnerOptimized(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++)
            dp[i] = nums[i];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) { // Starting index
                int j = i + len - 1; // Ending index
                // In 1D DP, dp[i] corresponds to dp[i][j-1]? Or dp[i+1][j]?
                // Let's trace carefully.
                // Usually dp[i] stores result for subarray starting at i with current length.
                // dp[i] update uses old dp[i] (which was range [i...j-1]) and old dp[i+1]
                // (range [i+1...j]).
                // dp[i] = max(nums[i] - dp[i+1], nums[j] - dp[i])
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
            }
        }
        return dp[0] >= 0;
    }

    public static void main(String[] args) {
        Solution_Minimax solution = new Solution_Minimax();
        int[] nums1 = { 1, 5, 2 };
        System.out.println("Result 1: " + solution.predictTheWinner(nums1)); // false

        int[] nums2 = { 1, 5, 233, 7 };
        System.out.println("Result 2: " + solution.predictTheWinner(nums2)); // true
    }
}
