package leetcode.P300_LongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 300: Longest Increasing Subsequence
     * Approach: Patience Sorting (Binary Search)
     * 
     * Theoretical Basis:
     * - build 'tails' array where tails[i] is the smallest tail of all increasing
     * subsequences of length i+1.
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            // Binary search for x in tails[0...size-1]
            int i = 0, j = size;
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }

            // i is the insertion point (first element >= x)
            tails[i] = x;
            if (i == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [10,9,2,5,3,7,101,18] -> 4 ([2,3,7,18])
        runTest(solution, new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }, 4);

        // [0,1,0,3,2,3] -> 4 ([0,1,2,3])
        runTest(solution, new int[] { 0, 1, 0, 3, 2, 3 }, 4);

        // [7,7,7,7] -> 1
        runTest(solution, new int[] { 7, 7, 7, 7 }, 1);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.lengthOfLIS(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
