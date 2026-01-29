package leetcode.P476_NumberComplement;

public class Solution {

    /**
     * Problem 476: Number Complement
     * Approach: Bit Manipulation (XOR with all-ones mask)
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int findComplement(int num) {
        // Find the highest set bit and create a mask with all 1s from that bit down
        int highestBit = Integer.highestOneBit(num);
        // (highestBit << 1) - 1 creates a mask. E.g. for 5 (101), highestBit is 4
        // (100).
        // (4 << 1) - 1 = 8 - 1 = 7 (111).
        // Handle overflow for 2^31
        long mask = ((long) highestBit << 1) - 1;
        return (int) (num ^ mask);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 5 (101) -> 2 (010)
        runTest(sol, 5, 2);

        // 1 (1) -> 0 (0)
        runTest(sol, 1, 0);

        // 8 (1000) -> 7 (0111)
        runTest(sol, 8, 7);
    }

    private static void runTest(Solution sol, int n, int expected) {
        int result = sol.findComplement(n);
        System.out.println("Input: " + n + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
