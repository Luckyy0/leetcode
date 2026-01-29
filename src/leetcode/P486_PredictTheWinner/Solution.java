package leetcode.P486_PredictTheWinner;

public class Solution {

    /**
     * Problem 486: Predict the Winner
     * Approach: Dynamic Programming (Max Difference)
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[i] stores the max difference (current player - opponent)
        // starting from index i given a fixed length
        int[] dp = new int[n];

        // Base case: length 1
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }

        // For lengths 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                // dp[i] (new) = max(nums[i] - dp[i+1] (old), nums[j] - dp[i] (old))
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
            }
        }

        return dp[0] >= 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,5,2] -> false
        System.out.println("Result: " + sol.predictTheWinner(new int[] { 1, 5, 2 }) + " (Expected: false)");

        // [1,5,233,7] -> true
        System.out.println("Result: " + sol.predictTheWinner(new int[] { 1, 5, 233, 7 }) + " (Expected: true)");
    }
}
