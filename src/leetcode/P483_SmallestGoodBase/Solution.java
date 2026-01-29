package leetcode.P483_SmallestGoodBase;

import java.math.BigInteger;

public class Solution {

    /**
     * Problem 483: Smallest Good Base
     * Approach: Binary Search on each possible length m
     * 
     * Time Complexity: O(log^2 N)
     * Space Complexity: O(1)
     */
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // m is the number of 1s. n = k^(m-1) + ... + k^0.
        // Max m is log2(n) + 1.
        for (int m = (int) (Math.log(num) / Math.log(2)) + 1; m >= 2; m--) {
            // Find k such that (k^m - 1) / (k - 1) = n
            // Use binary search for k.
            // Range for k: [2, num^(1/(m-1))]
            long left = 2;
            long right = (long) Math.pow(num, 1.0 / (m - 1));

            while (left <= right) {
                long mid = left + (right - left) / 2;
                BigInteger sum = BigInteger.ZERO;
                BigInteger kVal = BigInteger.valueOf(mid);

                // Calculate geometric sum: k^(m-1) + ... + 1
                // Better approach: sum = (k^m - 1) / (k - 1)
                // However, k^(m-1) + ... + 1 is safer against overflow with BigInteger
                BigInteger currentTerm = BigInteger.ONE;
                for (int i = 0; i < m; i++) {
                    sum = sum.add(currentTerm);
                    if (i < m - 1) {
                        currentTerm = currentTerm.multiply(kVal);
                    }
                }

                int cmp = sum.compareTo(BigInteger.valueOf(num));
                if (cmp == 0) {
                    return String.valueOf(mid);
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return String.valueOf(num - 1); // fallback for m=2
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "13" -> "3"
        System.out.println("Result: " + sol.smallestGoodBase("13") + " (Expected: 3)");

        // "4681" -> "8"
        System.out.println("Result: " + sol.smallestGoodBase("4681") + " (Expected: 8)");

        // "1000000000000000000" -> "999999999999999999"
        System.out
                .println("Result: " + sol.smallestGoodBase("1000000000000000000") + " (Expected: 999999999999999999)");
    }
}
