package leet_code.Problem_693_Easy_Binary_Number_with_Alternating_Bits;

public class Solution {

    /**
     * Checks if a positive integer has alternating binary bits.
     * Strategy: XOR n with its right shift. Result should be all 1s.
     * Use x & (x+1) == 0 to check if x is all 1s.
     * Time: O(1), Space: O(1).
     */
    public boolean hasAlternatingBits(int n) {
        // Step 1: Shift right and XOR.
        // If n = 10101, then n >> 1 is 01010.
        // n ^ (n >> 1) = 11111.
        long m = n ^ (n >> 1);

        // Step 2: Check if m is a number with all bits as 1.
        // Example: m = 7 (111), m + 1 = 8 (1000). 7 & 8 == 0.
        return (m & (m + 1)) == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result (5): " + sol.hasAlternatingBits(5)); // true
        System.out.println("Result (7): " + sol.hasAlternatingBits(7)); // false
        System.out.println("Result (11): " + sol.hasAlternatingBits(11)); // false
    }
}
