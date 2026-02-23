package leet_code.Problem_476_Easy_Number_Complement;

public class Solution_BitMask {

    /**
     * Finds the complement of the number.
     * Strategy: XOR with a mask of all 1s of the same length.
     * Time: O(1), Space: O(1).
     */
    public int findComplement(int num) {
        if (num == 0)
            return 1;

        // Find the mask with all 1s of the same bit length
        // e.g., for 5 (101), mask should be 7 (111).

        // Integer.highestOneBit(5) -> 4 (100)
        // (4 << 1) -> 8 (1000)
        // 8 - 1 -> 7 (111)
        // Note: Use long to prevent overflow if num is 2^30 or similar

        long highestBit = Integer.highestOneBit(num);
        long mask = (highestBit << 1) - 1;

        return num ^ (int) mask;
    }

    // Alternative iterative solution
    public int findComplementIterative(int num) {
        int mask = 1;
        while (mask < num) {
            mask = (mask << 1) | 1;
        }
        return num ^ mask;
    }

    public static void main(String[] args) {
        Solution_BitMask solution = new Solution_BitMask();
        System.out.println("Result (5): " + solution.findComplement(5)); // 2
        System.out.println("Result (1): " + solution.findComplement(1)); // 0
    }
}
