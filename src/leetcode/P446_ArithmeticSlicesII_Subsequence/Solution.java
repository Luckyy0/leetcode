package leetcode.P446_ArithmeticSlicesII_Subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 446: Arithmetic Slices II - Subsequence
     * Approach: Dynamic Programming with HashMaps
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long totalCount = 0;
        Map<Long, Integer>[] dp = new Map[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];

                int countAtJ = dp[j].getOrDefault(diff, 0);

                // Subsequences with length >= 3 are counted here
                totalCount += countAtJ;

                // Update count for current index i.
                // countAtJ + 1 (for the pair {nums[j], nums[i]})
                int currentAtI = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, currentAtI + countAtJ + 1);
            }
        }

        return (int) totalCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [2,4,6,8,10] -> 7
        int[] nums1 = { 2, 4, 6, 8, 10 };
        runTest(sol, nums1, 7);

        // [7,7,7,7,7] -> 16
        int[] nums2 = { 7, 7, 7, 7, 7 };
        runTest(sol, nums2, 16);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.numberOfArithmeticSlices(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
