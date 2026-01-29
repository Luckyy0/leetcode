package leetcode.P421_MaximumXOROfTwoNumbersInAnArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 421: Maximum XOR of Two Numbers in an Array
     * Approach: Greedy Prefix Check with Bit Manipulation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        for (int i = 30; i >= 0; i--) {
            // Mask to extract prefix up to bit i
            mask = mask | (1 << i);

            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // Assume the i-th bit can be 1
            int candidate = maxResult | (1 << i);
            for (int p : prefixes) {
                // If p1 ^ p2 == candidate, then p1 ^ candidate == p2
                if (prefixes.contains(p ^ candidate)) {
                    maxResult = candidate;
                    break;
                }
            }
        }

        return maxResult;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,10,5,25,2,8] -> 28
        runTest(solution, new int[] { 3, 10, 5, 25, 2, 8 }, 28);

        // [14,70,53,83,49,91,36,80,92,51,66,70] -> 127
        runTest(solution, new int[] { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 }, 127);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.findMaximumXOR(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
