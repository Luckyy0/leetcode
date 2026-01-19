package leetcode.P152_MaximumProductSubarray;

public class Solution {

    /**
     * Problem 152: Maximum Product Subarray
     * Approach: Optimized Dynamic Programming (Kadane's-like)
     * 
     * Theoretical Basis:
     * - Track both current max and current min.
     * - When encountering a negative number, the max and min values swap potential.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int res = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            // If current is negative, max and min swap roles when multiplied
            if (curr < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(curr, maxSoFar * curr);
            minSoFar = Math.min(curr, minSoFar * curr);

            res = Math.max(res, maxSoFar);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        runTest(solution, new int[] { 2, 3, -2, 4 }, 6);
        runTest(solution, new int[] { -2, 0, -1 }, 0);
        runTest(solution, new int[] { -2, 3, -4 }, 24);
        runTest(solution, new int[] { -2 }, -2);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.maxProduct(nums);
        System.out.print("Input: [");
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + (i == nums.length - 1 ? "" : ","));
        System.out.println("]");
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
