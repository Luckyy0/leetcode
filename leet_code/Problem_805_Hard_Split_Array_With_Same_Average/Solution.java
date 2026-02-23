package leet_code.Problem_805_Hard_Split_Array_With_Same_Average;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Determines if array can be split into two parts with the same average.
     * Strategy: Use DP with bitsets/sets to track possible sums for each length k.
     * Time: O(N^2 * S), Space: O(N * S).
     */
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return false;

        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        // Target: Find k elements with sum = totalSum * k / n
        // Check if any k in [1, n/2] can satisfy totalSum * k % n == 0
        boolean possible = false;
        for (int k = 1; k <= n / 2; k++) {
            if ((totalSum * k) % n == 0) {
                possible = true;
                break;
            }
        }
        if (!possible)
            return false;

        // dp[i] stores the sums possible with exactly i elements
        HashSet<Integer>[] dp = new HashSet[n / 2 + 1];
        for (int i = 0; i <= n / 2; i++)
            dp[i] = new HashSet<>();
        dp[0].add(0);

        for (int num : nums) {
            for (int i = n / 2; i >= 1; i--) {
                for (int s : dp[i - 1]) {
                    dp[i].add(s + num);
                }
            }
        }

        for (int k = 1; k <= n / 2; k++) {
            if ((totalSum * k) % n == 0 && dp[k].contains(totalSum * k / n)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println("Result 1: " + sol.splitArraySameAverage(n1)); // true

        int[] n2 = { 3, 1 };
        System.out.println("Result 2: " + sol.splitArraySameAverage(n2)); // false
    }
}
