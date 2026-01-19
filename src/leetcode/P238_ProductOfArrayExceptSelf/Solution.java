package leetcode.P238_ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 238: Product of Array Except Self
     * Approach: Left and Right Product Arrays (Optimized to O(1) space)
     * 
     * Theoretical Basis:
     * - result[i] = (Product of all elements left of i) * (Product of all elements
     * right of i)
     * - First pass computes left products.
     * - Second pass multiplies by right products on the fly.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1) extra space
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Phase 1: Calculate Left Products
        // result[i] will contain product of nums[0]...nums[i-1]
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // Phase 2: Calculate Right Products and multiply
        // R tracks the product of elements to the right
        int R = 1;
        for (int i = n - 1; i >= 0; i--) {
            // Update result[i] by multiplying with right product
            result[i] = result[i] * R;
            // Update R for next iteration (which is i-1)
            R = R * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,4] -> [24,12,8,6]
        runTest(solution, new int[] { 1, 2, 3, 4 }, new int[] { 24, 12, 8, 6 });

        // [-1,1,0,-3,3] -> [0,0,9,0,0]
        runTest(solution, new int[] { -1, 1, 0, -3, 3 }, new int[] { 0, 0, 9, 0, 0 });

        // [0, 0] -> [0, 0]
        runTest(solution, new int[] { 0, 0 }, new int[] { 0, 0 });
    }

    private static void runTest(Solution s, int[] nums, int[] expected) {
        // Clone input for correct printing if mutated (not mutated here but good
        // practice)
        int[] result = s.productExceptSelf(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Expected: " + Arrays.toString(expected));

        if (Arrays.equals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
