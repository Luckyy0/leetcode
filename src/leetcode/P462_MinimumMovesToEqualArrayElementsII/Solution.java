package leetcode.P462_MinimumMovesToEqualArrayElementsII;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 462: Minimum Moves to Equal Array Elements II
     * Approach: Median Strategy
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1)
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        long moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }
        return (int) moves;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,2,3] -> 2
        runTest(sol, new int[] { 1, 2, 3 }, 2);

        // [1,10,2,9] -> 16
        runTest(sol, new int[] { 1, 10, 2, 9 }, 16);
    }

    private static void runTest(Solution sol, int[] nums, int expected) {
        int result = sol.minMoves2(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
