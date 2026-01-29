package leetcode.P2167_MinimumTimeToRemoveAllCarsContainingIllegalGoods;

public class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int[] left = new int[n];

        // Calculate left costs
        // left[i] is cost to clear s[0...i]
        for (int i = 0; i < n; i++) {
            int prev = (i == 0) ? 0 : left[i - 1];
            if (s.charAt(i) == '1') {
                left[i] = Math.min(prev + 2, i + 1);
            } else {
                left[i] = Math.min(prev, i + 1); // Cost could technically be i+1 (remove all) or prev (keep mid
                                                 // removals). Cost doesn't increase if 0.
            }
        }

        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int prev = (i == n - 1) ? 0 : right[i + 1];
            if (s.charAt(i) == '1') {
                right[i] = Math.min(prev + 2, n - i);
            } else {
                right[i] = Math.min(prev, n - i);
            }
        }

        int minCost = right[0]; // If we rely only on right part (split before 0)
        minCost = Math.min(minCost, left[n - 1]); // Only left

        for (int i = 0; i < n - 1; i++) {
            // Split: left handles 0..i, right handles i+1..n-1
            minCost = Math.min(minCost, left[i] + right[i + 1]);
        }

        return minCost;
    }
}
