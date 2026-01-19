package leetcode.P191_NumberOf1Bits;

public class Solution {

    /**
     * Problem 191: Number of 1 Bits
     * Approach: Brian Kernighan's Algorithm
     * 
     * Theoretical Basis:
     * - n & (n - 1) clears the rightmost set bit.
     * - We repeat this until n becomes 0.
     * - This is faster than checking all 32 bits if the number of set bits is
     * small.
     * 
     * Time Complexity: O(K) where K is number of set bits.
     * Space Complexity: O(1)
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        System.out.println("Test 1 (11): " + solution.hammingWeight(11)); // 1011 -> 3

        // Example 2
        System.out.println("Test 2 (128): " + solution.hammingWeight(128)); // 10000000 -> 1

        // Example 3
        System.out.println("Test 3 (2147483645): " + solution.hammingWeight(2147483645)); // 30
    }
}
