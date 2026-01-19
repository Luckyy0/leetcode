package leetcode.P053_MaximumSubarray;

public class Solution {

    /**
     * Problem 53: Maximum Subarray
     * Approach: Kadane's Algorithm
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0; // Though problem says length >= 1

        int currentMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Equivalent to: currentMax = Math.max(nums[i], currentMax + nums[i]);
            // If currentMax + nums[i] < nums[i], it means currentMax was negative, so we
            // discard it and start fresh at nums[i].
            if (currentMax < 0) {
                currentMax = nums[i];
            } else {
                currentMax += nums[i];
            }

            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }, 6);
        runTest(solution, new int[] { 1 }, 1);
        runTest(solution, new int[] { 5, 4, -1, 7, 8 }, 23);
        runTest(solution, new int[] { -1 }, -1);
        runTest(solution, new int[] { -2, -1 }, -1);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        System.out.println("Input length: " + nums.length);
        int result = s.maxSubArray(nums);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
