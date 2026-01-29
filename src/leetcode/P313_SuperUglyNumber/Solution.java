package leetcode.P313_SuperUglyNumber;

public class Solution {

    /**
     * Problem 313: Super Ugly Number
     * Approach: Dynamic Programming with K Pointers
     * 
     * Time Complexity: O(N * K)
     * Space Complexity: O(N + K)
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int k = primes.length;
        int[] indices = new int[k]; // points to index in dp

        for (int i = 1; i < n; i++) {
            long minVal = Long.MAX_VALUE; // Avoid overflow during comparison

            // Find minimum candidate
            for (int j = 0; j < k; j++) {
                long candidate = (long) primes[j] * dp[indices[j]];
                if (candidate < minVal) {
                    minVal = candidate;
                }
            }

            dp[i] = (int) minVal;

            // Advance pointers
            for (int j = 0; j < k; j++) {
                if ((long) primes[j] * dp[indices[j]] == minVal) {
                    indices[j]++;
                }
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 12, [2,7,13,19] -> 32
        runTest(solution, 12, new int[] { 2, 7, 13, 19 }, 32);

        // 1, [2,3,5] -> 1
        runTest(solution, 1, new int[] { 2, 3, 5 }, 1);
    }

    private static void runTest(Solution s, int n, int[] primes, int expected) {
        int result = s.nthSuperUglyNumber(n, primes);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
