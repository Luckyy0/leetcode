package leetcode.P442_FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 442: Find All Duplicates in an Array
     * Approach: Sign Flipping (Using Array as Hash Map)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int idx = val - 1;

            if (nums[idx] < 0) {
                // We've seen this value before
                result.add(val);
            } else {
                // First time seeing this value, mark as seen by flipping sign
                nums[idx] = -nums[idx];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [4,3,2,7,8,2,3,1] -> [2, 3]
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Result 1: " + sol.findDuplicates(nums1));

        // [1,1,2] -> [1]
        int[] nums2 = { 1, 1, 2 };
        System.out.println("Result 2: " + sol.findDuplicates(nums2));

        // [1] -> []
        int[] nums3 = { 1 };
        System.out.println("Result 3: " + sol.findDuplicates(nums3));
    }
}
