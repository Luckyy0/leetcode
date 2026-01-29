package leetcode.P376_WiggleSubsequence;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 376: Wiggle Subsequence
     * Approach: Greedy (State Machine)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,7,4,9,2,5] -> 6
        runTest(solution, new int[] { 1, 7, 4, 9, 2, 5 }, 6);

        // [1,17,5,10,13,15,10,5,16,8] -> 7
        runTest(solution, new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }, 7);

        // [1,2,3,4,5,6,7,8,9] -> 2
        runTest(solution, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 2);
    }

    private static void runTest(Solution s, int[] nums, int expected) {
        int result = s.wiggleMaxLength(nums);
        System.out
                .println("Input: " + Arrays.toString(nums) + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
