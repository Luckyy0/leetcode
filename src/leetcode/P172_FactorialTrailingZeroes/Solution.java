package leetcode.P172_FactorialTrailingZeroes;

public class Solution {

    /**
     * Problem 172: Factorial Trailing Zeroes
     * Approach: Count factors of 5
     * 
     * Theoretical Basis:
     * - Zeroes are made of 2 * 5.
     * - Count multiples of 5, 25, 125, etc.
     * 
     * Time Complexity: O(log5(N))
     * Space Complexity: O(1)
     */
    public int trailingZeroes(int n) {
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 3 -> 0
        runTest(solution, 3, 0);

        // 5 -> 1
        runTest(solution, 5, 1);

        // 10 -> 2
        runTest(solution, 10, 2);

        // 25 -> 6 (5, 10, 15, 20 are +1 each, 25 is +2)
        runTest(solution, 25, 6);

        // 0 -> 0
        runTest(solution, 0, 0);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.trailingZeroes(n);
        System.out.println(n + "! has " + result + " zeroes (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
