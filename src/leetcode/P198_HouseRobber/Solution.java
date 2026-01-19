package leetcode.P198_HouseRobber;

public class Solution {

    /**
     * Problem 198: House Robber
     * Approach: Dynamic Programming (Space Optimized)
     * 
     * Theoretical Basis:
     * - For each house, decide whether to rob it or not.
     * - Current max = max(prevRobbed, currentHouse + prevPrevRobbed)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int prevPrev = 0;
        int prev = 0;

        for (int num : nums) {
            int current = Math.max(prev, num + prevPrev);
            prevPrev = prev;
            prev = current;
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] n1 = { 1, 2, 3, 1 };
        System.out.println("Test 1: " + solution.rob(n1)); // 1+3=4

        // Example 2
        int[] n2 = { 2, 7, 9, 3, 1 };
        System.out.println("Test 2: " + solution.rob(n2)); // 2+9+1=12
    }
}
