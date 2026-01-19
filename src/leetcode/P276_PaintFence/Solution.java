package leetcode.P276_PaintFence;

public class Solution {

    /**
     * Problem 276: Paint Fence
     * Approach: Dynamic Programming (Optimized Space)
     * 
     * Theoretical Basis:
     * - Total(i) = (Total(i-1) + Total(i-2)) * (k - 1)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int numWays(int n, int k) {
        if (n == 0)
            return 0;
        if (n == 1)
            return k;
        if (n == 2)
            return k * k;

        int prev2 = k; // Total(1)
        int prev1 = k * k; // Total(2)

        for (int i = 3; i <= n; i++) {
            // New Total = (Prev1 + Prev2) * (k - 1)
            int current = (prev1 + prev2) * (k - 1);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // n=3, k=2 -> 6
        runTest(solution, 3, 2, 6);

        // n=1, k=1 -> 1
        runTest(solution, 1, 1, 1);

        // n=7, k=2 -> 42
        runTest(solution, 7, 2, 42);
    }

    private static void runTest(Solution s, int n, int k, int expected) {
        int result = s.numWays(n, k);
        System.out.println("n=" + n + ", k=" + k + " -> Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
