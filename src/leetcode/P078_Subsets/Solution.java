package leetcode.P078_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 78: Subsets
     * Approach: Backtracking
     * Time Complexity: O(N * 2^N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(i + 1, nums, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 2, 3 }, 8);
        runTest(solution, new int[] { 0 }, 2);
    }

    private static void runTest(Solution s, int[] nums, int expectedCount) {
        System.out.println("Input input length: " + nums.length);
        List<List<Integer>> result = s.subsets(nums);
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
