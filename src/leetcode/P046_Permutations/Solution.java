package leetcode.P046_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 46: Permutations
     * Approach: Backtracking via Swapping
     * Time Complexity: O(n * n!)
     * Space Complexity: O(n)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Convert to Integers for easier list creation or just handle manually
        // Since we are swapping the input array, we can copy it at the leaf node
        backtrack(nums, 0, result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, result);
            swap(nums, start, i); // Backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, new int[] { 1, 2, 3 });
        runTest(solution, new int[] { 0, 1 });
        runTest(solution, new int[] { 1 });
    }

    private static void runTest(Solution s, int[] nums) {
        System.out.println("Input size: " + nums.length);
        List<List<Integer>> result = s.permute(nums);
        System.out.println("Output count: " + result.size());

        long expectedCount = 1;
        for (int i = 1; i <= nums.length; i++)
            expectedCount *= i;

        System.out.println("Expected count: " + expectedCount);

        if (result.size() == expectedCount) {
            System.out.println("PASS (Count matches)");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
