package leetcode.P137_SingleNumberII;

public class Solution {

    /**
     * Problem 137: Single Number II
     * Approach: Bitwise State Logic
     * 
     * Theoretical Basis:
     * - Track bits appearing 1 time and 2 times (mod 3).
     * - logic:
     * ones = (ones ^ num) & ~twos;
     * twos = (twos ^ num) & ~ones;
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            // bits that appear 1 time
            ones = (ones ^ num) & ~twos;
            // bits that appear 2 times
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        System.out.println("Test 1: " + solution.singleNumber(new int[] { 2, 2, 3, 2 })); // Expected: 3
        System.out.println("Test 2: " + solution.singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 })); // Expected: 99
    }
}
