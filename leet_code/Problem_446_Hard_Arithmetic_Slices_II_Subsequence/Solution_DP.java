package leet_code.Problem_446_Hard_Arithmetic_Slices_II_Subsequence;

import java.util.*;

public class Solution_DP {

    /**
     * Counts all arithmetic subsequences of length >= 3.
     * Strategy: DP with maps for each index. dp[i].get(diff) counts subsequences
     * ending at i.
     * Time: O(n^2), Space: O(n^2).
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int totalCount = 0;

        // dp[i] maps common difference -> number of arithmetic subsequences ending at i
        // These subsequences have length >= 2.
        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int countAtJ = dp[j].getOrDefault(diff, 0);

                // countAtJ is number of seqs ending at j with this diff (length >= 2)
                // When adding nums[i], these become seqs of length >= 3.
                totalCount += countAtJ;

                // Update dp[i]:
                // Seqs ending at i = (Seqs ending at j + nums[i]) + ([nums[j], nums[i]])
                int countAtI = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, countAtI + countAtJ + 1);
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();
        int[] nums = { 2, 4, 6, 8, 10 };
        System.out.println("Result: " + solution.numberOfArithmeticSlices(nums)); // 7
    }
}
