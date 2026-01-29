package leetcode.P491_NonDecreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Problem 491: Non-decreasing Subsequences
     * Approach: Backtracking with Local Level De-duplication
     * 
     * Time Complexity: O(2^N)
     * Space Complexity: O(N)
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> current, List<List<Integer>> res) {
        if (current.size() >= 2) {
            res.add(new ArrayList<>(current));
        }

        Set<Integer> usedInThisLevel = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (usedInThisLevel.contains(nums[i]))
                continue;

            if (current.isEmpty() || nums[i] >= current.get(current.size() - 1)) {
                usedInThisLevel.add(nums[i]);
                current.add(nums[i]);
                dfs(nums, i + 1, current, res);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [4,6,7,7]
        int[] nums1 = { 4, 6, 7, 7 };
        List<List<Integer>> res1 = sol.findSubsequences(nums1);
        System.out.println("Result count 1: " + res1.size() + " (Expected: 8)");
        System.out.println("Result 1: " + res1);

        // [4,4,3,2,1] -> [[4,4]]
        int[] nums2 = { 4, 4, 3, 2, 1 };
        System.out.println("Result 2: " + sol.findSubsequences(nums2));
    }
}
