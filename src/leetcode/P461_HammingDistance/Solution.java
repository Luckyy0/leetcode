package leetcode.P461_HammingDistance;

public class Solution {

    /**
     * Problem 461: Hamming Distance
     * Approach: XOR and Bit Count
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        return Integer.bitCount(xor);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 1 (0001), 4 (0100) -> 2
        runTest(sol, 1, 4, 2);

        // 3 (0011), 1 (0001) -> 1
        runTest(sol, 3, 1, 1);
    }

    private static void runTest(Solution sol, int x, int y, int expected) {
        int result = sol.hammingDistance(x, y);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
