package leet_code.Problem_829_Hard_Consecutive_Numbers_Sum;

public class Solution {

    /**
     * Calculates the number of ways to write n as a sum of consecutive positive
     * integers.
     * Strategy: Use the sum of arithmetic progression formula: n = k*a + k(k+1)/2.
     * Loop through possible lengths of the progression k.
     * Time: O(sqrt(N)), Space: O(1).
     */
    public int consecutiveNumbersSum(int n) {
        int resultCount = 0;

        // Let the sequence be a+1, a+2, ..., a+k
        // Sum = k*a + (1 + 2 + ... + k) = k*a + k*(k+1)/2 = n
        // Where a >= 0 (since starting numbers a+1 must be positive integers)

        // Condition for a valid sequence of length k:
        // k*a = n - k*(k+1)/2 must be divisible by k and >= 0.

        for (long k = 1; (k * (k + 1) / 2) <= n; k++) {
            long remaining = n - (k * (k + 1) / 2);
            if (remaining % k == 0) {
                resultCount++;
            }
        }

        return resultCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1 (n=5): " + sol.consecutiveNumbersSum(5)); // 2
        System.out.println("Result 2 (n=9): " + sol.consecutiveNumbersSum(9)); // 3
        System.out.println("Result 3 (n=15): " + sol.consecutiveNumbersSum(15)); // 4
    }
}
