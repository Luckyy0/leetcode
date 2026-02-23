package leet_code.Problem_717_Easy_1_bit_and_2_bit_Characters;

public class Solution {

    /**
     * Determines if the last character is a 1-bit character.
     * Strategy: Linear scan with jumps based on the leading bit.
     * Time: O(N), Space: O(1).
     */
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        // Scan until we reach the last character start point
        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2; // Mandatory jump for 2-bit char
            } else {
                i += 1; // Mandatory jump for 1-bit char
            }
        }

        // If we landed exactly on the last index, it must be a 1-bit char.
        return i == n - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] bits1 = { 1, 0, 0 };
        System.out.println("Result 1: " + sol.isOneBitCharacter(bits1)); // true

        int[] bits2 = { 1, 1, 1, 0 };
        System.out.println("Result 2: " + sol.isOneBitCharacter(bits2)); // false
    }
}
