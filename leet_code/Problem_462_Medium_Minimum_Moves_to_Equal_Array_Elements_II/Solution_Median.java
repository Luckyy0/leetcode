package leet_code.Problem_462_Medium_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Arrays;

public class Solution_Median {

    /**
     * Finds the minimum moves to make all array elements equal.
     * Strategy: Median minimizes the sum of absolute differences.
     * Time: O(N log N), Space: O(1).
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int median = nums[n / 2];

        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Median solution = new Solution_Median();
        int[] nums = { 1, 10, 2, 9 };
        System.out.println("Result: " + solution.minMoves2(nums)); // 16
    }
}
