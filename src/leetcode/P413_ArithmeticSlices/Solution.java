package leetcode.P413_ArithmeticSlices;

public class Solution {

    /**
     * Problem 413: Arithmetic Slices
     * Approach: Dynamic Programming (Space-Optimized)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int total = 0;
        int current = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                current += 1;
                total += current;
            } else {
                current = 0;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1, 2, 3, 4] -> 3
        runTest(solution, new int[] { 1, 2, 3, 4 }, 3);

        // [1] -> 0
        runTest(solution, new int[] { 1 }, 0);

        // [1, 2, 3, 8, 9, 10] -> 2 ([1,2,3] and [8,9,10])
        runTest(solution, new int[] { 1, 2, 3, 8, 9, 10 }, 2);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.numberOfArithmeticSlices(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
