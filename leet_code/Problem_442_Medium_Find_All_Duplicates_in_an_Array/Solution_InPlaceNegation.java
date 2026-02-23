package leet_code.Problem_442_Medium_Find_All_Duplicates_in_an_Array;

import java.util.*;

public class Solution_InPlaceNegation {

    /**
     * Finds all elements that appear twice in an array where values are [1, n].
     * Strategy: Use negation at index (val-1) to mark visited status.
     * Time: O(n), Space: O(1) extra.
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int idx = val - 1;

            if (nums[idx] < 0) {
                // If already negative, it's the second time we visit this value
                res.add(val);
            } else {
                // Mark as visited by negating
                nums[idx] = -nums[idx];
            }
        }

        // Optional: restore the array if needed
        return res;
    }

    public static void main(String[] args) {
        Solution_InPlaceNegation solution = new Solution_InPlaceNegation();
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Result: " + solution.findDuplicates(nums)); // [2, 3]
    }
}
