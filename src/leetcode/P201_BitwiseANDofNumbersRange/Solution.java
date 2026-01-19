package leetcode.P201_BitwiseANDofNumbersRange;

public class Solution {

    /**
     * Problem 201: Bitwise AND of Numbers Range
     * Approach: Common Bit Prefix (Shift Right)
     * 
     * Theoretical Basis:
     * - The result is the common prefix of 'left' and 'right', padded with zeros.
     * 
     * Time Complexity: O(1) (Bounded by 32 bits)
     * Space Complexity: O(1)
     */
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // Find the common prefix
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }

        return left << shift;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 5 (101), 7 (111) -> 4 (100)
        runTest(solution, 5, 7, 4);

        // 0, 0 -> 0
        runTest(solution, 0, 0, 0);

        // 1, 2147483647 -> 0
        runTest(solution, 1, 2147483647, 0);
    }

    private static void runTest(Solution s, int left, int right, int expected) {
        int result = s.rangeBitwiseAnd(left, right);
        System.out.println("Range [" + left + ", " + right + "] -> AND: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
