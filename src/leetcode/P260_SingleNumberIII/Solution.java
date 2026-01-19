package leetcode.P260_SingleNumberIII;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 260: Single Number III
     * Approach: Bit Manipulation (XOR Partitioning)
     * 
     * Theoretical Basis:
     * - XOR of all numbers gives a ^ b.
     * - Use any set bit in a ^ b to split numbers into two groups.
     * - One group contains a (and duplicates), other contains b (and duplicates).
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int[] singleNumber(int[] nums) {
        // Pass 1: Get the XOR of the two unique numbers
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }

        // Find rightmost set bit
        // Note: bit will have only one bit set.
        // E.g. diff = 6 (110), -diff = -6 (...010 inverted + 1 = ...010). 6 & -6 = 2
        // (010).
        int bit = diff & -diff;

        // Pass 2: Partition
        int[] result = new int[2]; // [0] for group 0, [1] for group 1

        for (int num : nums) {
            if ((num & bit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,1,3,2,5] -> [3, 5] (order varies)
        runTest(solution, new int[] { 1, 2, 1, 3, 2, 5 });

        // [-1, 0] -> [-1, 0]
        runTest(solution, new int[] { -1, 0 });

        // [0, 1] -> [1, 0]
        runTest(solution, new int[] { 0, 1 });
    }

    private static void runTest(Solution s, int[] nums) {
        int[] result = s.singleNumber(nums);
        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Result: " + Arrays.toString(result));

        // Verification logic
        // Check if result contains correct unique numbers
        // Simple way: sort and check manually or trust the output for now
        System.out.println("-----------------");
    }
}
