package leetcode.P202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 202: Happy Number
     * Approach: HashSet Cycle Detection
     * 
     * Theoretical Basis:
     * - Compute sum of squares of digits.
     * - Check if we have seen this sum before to detect infinite loop.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1) effectively
     */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    private int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 19 -> true
        runTest(solution, 19, true);

        // 2 -> false
        runTest(solution, 2, false);
    }

    private static void runTest(Solution s, int n, boolean expected) {
        boolean result = s.isHappy(n);
        System.out.println("Input: " + n + " -> Happy? " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
