package leetcode.P440_KthSmallestInLexicographicalOrder;

public class Solution {

    /**
     * Problem 440: K-th Smallest in Lexicographical Order
     * Approach: Denary Tree Traversal
     * 
     * Time Complexity: O((log N)^2)
     * Space Complexity: O(1)
     */
    public int findKthNumber(int n, int k) {
        long curr = 1;
        k = k - 1; // 0-indexed adjustment

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);
            if (steps <= k) {
                // Move to next sibling
                curr += 1;
                k -= steps;
            } else {
                // Move to first child
                curr *= 10;
                k -= 1;
            }
        }

        return (int) curr;
    }

    // Calculates how many numbers exist in range [1, n] starting with prefix n1
    private long countSteps(int n, long n1, long n2) {
        long steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // n = 13, k = 2 -> 10
        runTest(sol, 13, 2, 10);

        // n = 1, k = 1 -> 1
        runTest(sol, 1, 1, 1);

        // n = 100, k = 10 -> 18
        // [1, 10, 100, 11, 12, 13, 14, 15, 16, 17, 18...]
        // Wait, order is 1, 10, 100, 11, 12, 13, 14, 15, 16, 17.
        // 17 would be 10th.
        runTest(sol, 100, 10, 17);
    }

    private static void runTest(Solution sol, int n, int k, int expected) {
        int result = sol.findKthNumber(n, k);
        System.out.println("n: " + n + ", k: " + k + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
