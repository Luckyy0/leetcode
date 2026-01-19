package leetcode.P217_ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 217: Contains Duplicate
     * Approach: HashSet
     * 
     * Theoretical Basis:
     * - Use a Set to track seen elements.
     * - O(1) avg lookup.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [1,2,3,1] -> true
        runTest(solution, new int[] { 1, 2, 3, 1 }, true);

        // [1,2,3,4] -> false
        runTest(solution, new int[] { 1, 2, 3, 4 }, false);

        // [1,1,1,3,3,4,3,2,4,2] -> true
        runTest(solution, new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }, true);
    }

    private static void runTest(Solution s, int[] nums, boolean expected) {
        boolean result = s.containsDuplicate(nums);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
