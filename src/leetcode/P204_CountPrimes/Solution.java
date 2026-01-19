package leetcode.P204_CountPrimes;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 204: Count Primes
     * Approach: Sieve of Eratosthenes
     * 
     * Theoretical Basis:
     * - Iteratively mark multiples of primes as composite.
     * - Optimization: start inner loop at i*i.
     * 
     * Time Complexity: O(N log log N)
     * Space Complexity: O(N)
     */
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Loop up to sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                // Mark multiples starting from i*i
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 10 -> 4 (2, 3, 5, 7)
        runTest(solution, 10, 4);

        // 0 -> 0
        runTest(solution, 0, 0);

        // 1 -> 0
        runTest(solution, 1, 0);

        // 20 -> 8 (2, 3, 5, 7, 11, 13, 17, 19)
        runTest(solution, 20, 8);
    }

    private static void runTest(Solution s, int n, int expected) {
        int result = s.countPrimes(n);
        System.out.println("Primes < " + n + ": " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
