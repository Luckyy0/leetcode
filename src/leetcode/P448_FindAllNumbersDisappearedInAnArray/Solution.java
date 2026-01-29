package leetcode.P448_FindAllNumbersDisappearedInAnArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 448: Find All Numbers Disappeared in an Array
     * Approach: Index Marking (In-place)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [4,3,2,7,8,2,3,1] -> [5, 6]
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Result 1: " + sol.findDisappearedNumbers(nums1));

        // [1,1] -> [2]
        int[] nums2 = { 1, 1 };
        System.out.println("Result 2: " + sol.findDisappearedNumbers(nums2));
    }
}
