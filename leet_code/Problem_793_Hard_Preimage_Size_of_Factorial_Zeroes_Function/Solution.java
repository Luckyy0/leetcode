package leet_code.Problem_793_Hard_Preimage_Size_of_Factorial_Zeroes_Function;

public class Solution {

    /**
     * Finds the number of integers x such that trailingZeroes(x!) == k.
     * Strategy: Binary Search on Monotonic Function f(x). Answer is 0 or 5.
     * Time: O((log K)^2), Space: O(1).
     */
    public int preimageSizeFZF(int k) {
        // f(x) increases monotonically.
        // It skips values at multiples of powers of 5.
        // If k is a value that f(x) takes, it takes it for exactly 5 consecutive
        // integers (e.g. 5,6,7,8,9 have same trailing zeroes).
        // If k is skipped, the answer is 0.

        // Find smallest x such that f(x) >= k
        long left = binarySearchLeft(k);

        // Check if f(left) is exactly k
        if (trailingZeroes(left) == k) {
            return 5;
        }
        return 0;
    }

    // Binary search for the smallest x such that f(x) >= k
    private long binarySearchLeft(int k) {
        long lo = 0;
        long hi = 5L * (k + 1); // Upper bound approximation (f(x) ~ x/5)

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    // Calculates number of trailing zeroes in x!
    private long trailingZeroes(long x) {
        long count = 0;
        while (x > 0) {
            x /= 5;
            count += x;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.preimageSizeFZF(0)); // 5
        System.out.println("Result 2: " + sol.preimageSizeFZF(5)); // 0
        System.out.println("Result 3: " + sol.preimageSizeFZF(3)); // 5
    }
}
