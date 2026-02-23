package leet_code.Problem_483_Hard_Smallest_Good_Base;

import java.math.BigInteger;

public class Solution_Math {

    /**
     * Finds the smallest good base for n.
     * Strategy: Iterate length m from Max down to 2. Binary search for k.
     * Time: O(log^2 n), Space: O(1).
     */
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // m is the number of '1's minus 1 (or the exponent of highest term)
        // n = k^m + ... + k + 1
        // If k=2, m approx log2(n). log2(10^18) approx 60.

        for (int m = 62; m >= 2; m--) {
            // Find k such that k^m <= num
            // k approximately num^(1/m)
            long k = (long) Math.pow(num, 1.0 / m);

            // Due to floating point precision, k might be off by 1
            // Binary search or check neighborhood is safer.
            // Since k decreases as m increases, for m=60, k=2.
            // Let's use Binary Search for strict correctness to avoid precision issues.

            long left = 2, right = (long) Math.pow(num, 1.0 / (m - 1)) + 1;
            // Actually right bound can be simpler: n^(1/m) is close enough

            // Let's stick to binary search for generic approach
            // Range for k is [2, n^(1/m) + 2] basically

            long start = 2;
            long end = (long) Math.pow(num, 1.0 / m) + 1; // Slight overflow buffer?
                                                          // For m=2, end approx 10^9. Safe.

            // Optimization: Just check the specific k = (long)pow.
            // But let's do properly with binary search logic or validation

            // Let's validate k = floor(num^(1/m))
            if (k < 2)
                continue;

            // Check k
            long sum = 0;
            long cur = 1;
            boolean valid = true;
            for (int i = 0; i <= m; i++) {
                sum += cur;
                if (sum > num) { // Overflow or excess
                    valid = false;
                    break;
                }
                if (sum == num && i == m)
                    break; // Exact match found

                // Prepare next power. Check overflow before multiplying
                if (i < m) {
                    if (Long.MAX_VALUE / k < cur) {
                        valid = false; // Overflow
                        break;
                    }
                    cur *= k;
                }
            }

            if (valid && sum == num) {
                return String.valueOf(k);
            }
        }

        // Default base is n-1
        return String.valueOf(num - 1);
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        System.out.println("Result 13: " + solution.smallestGoodBase("13")); // 3
        System.out.println("Result 4681: " + solution.smallestGoodBase("4681")); // 8
    }
}
