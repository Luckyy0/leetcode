package leetcode.P190_ReverseBits;

public class Solution {

    /**
     * Problem 190: Reverse Bits
     * Approach: Bitwise Shifting
     * 
     * Theoretical Basis:
     * - We extract bits from n one by one from right to left.
     * - We place these bits into result from left to right.
     * 
     * Time Complexity: O(1) (exactly 32 iterations)
     * Space Complexity: O(1)
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result to make space for the next bit
            result <<= 1;
            // Get the last bit of n and add it to result
            result |= (n & 1);
            // Shift n to the right to get the next bit
            n >>>= 1; // Use unsigned right shift
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int n1 = 43261596;
        int res1 = solution.reverseBits(n1);
        System.out.println("Test 1: Input " + n1 + ", Result " + res1);
        // Binary of 43261596: 00000010100101000001111010011100
        // Reversed: 00111001011110000010100101000000 (964176192)
    }
}
