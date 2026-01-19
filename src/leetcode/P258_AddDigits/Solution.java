package leetcode.P258_AddDigits;

public class Solution {

    /**
     * Problem 258: Add Digits
     * Approach: Digital Root Formula (O(1))
     * 
     * Theoretical Basis:
     * - The digital root is congruent to n mod 9.
     * - Formula: 1 + (num - 1) % 9 handles mapping 0..8 result to 1..9.
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 38 -> 2
        runTest(solution, 38, 2);

        // 0 -> 0
        runTest(solution, 0, 0);

        // 9 -> 9
        runTest(solution, 9, 9);

        // 18 -> 9
        runTest(solution, 18, 9);

        // 10 -> 1
        runTest(solution, 10, 1);
    }

    private static void runTest(Solution s, int num, int expected) {
        int result = s.addDigits(num);
        System.out.println("Input: " + num + " -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
