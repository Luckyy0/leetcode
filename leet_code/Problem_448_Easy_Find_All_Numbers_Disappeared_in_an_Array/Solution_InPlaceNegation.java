package leet_code.Problem_448_Easy_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.*;

public class Solution_InPlaceNegation {

    /**
     * Finds all numbers in [1, n] that do not appear in an array.
     * Strategy: Mark existence by negating value at corresponding index.
     * Time: O(n), Space: O(1) extra.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_InPlaceNegation solution = new Solution_InPlaceNegation();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Result: " + solution.findDisappearedNumbers(nums)); // [5, 6]
    }
}
