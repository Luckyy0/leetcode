package leet_code.Problem_377_Medium_Combination_Sum_IV;

public class Solution_DP {

    /**
     * Finds number of combinations that add up to target.
     * Use DP (Bottom-up).
     * Time: O(T * N), Space: O(T).
     * 
     * Tìm số lượng các tổ hợp có tổng bằng target.
     * Sử dụng DP (Dưới lên).
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1,2,3], target=4 -> 7
        System.out.println("Result 1: " + solution.combinationSum4(new int[] { 1, 2, 3 }, 4));

        // Test Case 2: [9], target=3 -> 0
        System.out.println("Result 2: " + solution.combinationSum4(new int[] { 9 }, 3));
    }
}
