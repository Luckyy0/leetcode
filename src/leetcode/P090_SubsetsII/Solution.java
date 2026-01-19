package leetcode.P090_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 90: Subsets II
     * Approach: Backtracking with Sorting and Duplicate Skipping
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Essential to handle duplicates
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // If current element is same as previous and we are not at the start of THIS
            // level's iteration,
            // then it's a duplicate branch, skip it.
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 2, 2 }, 6);
        runTest(solution, new int[] { 0 }, 2);
    }

    private static void runTest(Solution s, int[] nums, int expectedCount) {
        System.out.println("Input: " + Arrays.toString(nums));
        List<List<Integer>> result = s.subsetsWithDup(nums);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");
        System.out.println("Result: " + result);

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
