package leetcode.P136_SingleNumber;

public class Solution {

    /**
     * Problem 136: Single Number
     * Approach: Bitwise XOR
     * 
     * Theoretical Basis:
     * - a ^ a = 0
     * - a ^ 0 = a
     * - order doesn't matter
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println("Test 1: " + solution.singleNumber(new int[] { 2, 2, 1 })); // Expected: 1
        System.out.println("Test 2: " + solution.singleNumber(new int[] { 4, 1, 2, 1, 2 })); // Expected: 4
        System.out.println("Test 3: " + solution.singleNumber(new int[] { 1 })); // Expected: 1
    }
}
