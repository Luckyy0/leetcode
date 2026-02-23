package leet_code.Problem_491_Medium_Non_decreasing_Subsequences;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Finds all non-decreasing subsequences.
     * Strategy: Backtracking with HashSet for deduplication at each level.
     * Time: O(2^N), Space: O(N).
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() >= 2) {
            result.add(new ArrayList<>(current));
        }

        // Track used numbers at this particular recursion level to allow duplicates in
        // input
        // but prevent duplicate recursive calls for the same number value at the same
        // position in subsequence.
        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            // Check non-decreasing condition
            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                // Deduplicate logic
                if (used.contains(nums[i])) {
                    continue;
                }

                used.add(nums[i]);
                current.add(nums[i]);
                backtrack(nums, i + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();
        int[] nums = { 4, 6, 7, 7 };
        System.out.println("Result: " + solution.findSubsequences(nums));
    }
}
