package leet_code.Problem_698_Medium_Partition_to_K_Equal_Sum_Subsets;

import java.util.*;

public class Solution {

    /**
     * Determines if an array can be partitioned into k equal sum subsets.
     * Strategy: Backtracking with bitmask memoization.
     * Time: O(2^N * N), Space: O(2^N).
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        // Basic mathematical constraints
        if (sum % k != 0)
            return false;
        int target = sum / k;

        // Sort descending to facilitate early pruning
        Arrays.sort(nums);
        reverse(nums);

        if (nums[0] > target)
            return false;

        // Memoization map: mask -> boolean result
        Map<Integer, Boolean> memo = new HashMap<>();
        return backtrack(nums, 0, 0, target, k, 0, memo);
    }

    private boolean backtrack(int[] nums, int mask, int currentSum, int target, int k, int startIdx,
            Map<Integer, Boolean> memo) {
        // If we have formed k-1 subsets, the last one is automatically valid
        if (k == 1)
            return true;

        if (memo.containsKey(mask))
            return memo.get(mask);

        // If target sum for current subset reached, start the next subset
        if (currentSum == target) {
            boolean res = backtrack(nums, mask, 0, target, k - 1, 0, memo);
            memo.put(mask, res);
            return res;
        }

        for (int i = startIdx; i < nums.length; i++) {
            // If bit is already set (element used)
            if (((mask >> i) & 1) == 1)
                continue;

            // Optimization: if current value + remaining is too large
            if (currentSum + nums[i] > target)
                continue;

            // Try adding nums[i] to current subset
            if (backtrack(nums, mask | (1 << i), currentSum + nums[i], target, k, i + 1, memo)) {
                return true;
            }
        }

        memo.put(mask, false);
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 4, 3, 2, 3, 5, 2, 1 };
        System.out.println("Result 1 (k=4): " + sol.canPartitionKSubsets(nums1, 4)); // true

        int[] nums2 = { 1, 2, 3, 4 };
        System.out.println("Result 2 (k=3): " + sol.canPartitionKSubsets(nums2, 3)); // false
    }
}
