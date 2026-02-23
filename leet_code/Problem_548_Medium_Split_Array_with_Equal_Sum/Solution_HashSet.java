package leet_code.Problem_548_Medium_Split_Array_with_Equal_Sum;

import java.util.HashSet;

public class Solution_HashSet {

    /**
     * Checks if array can be split into 4 equal sum parts.
     * Strategy: Fix j, find potential sums from i and k parts.
     * Time: O(N^2), Space: O(N).
     */
    public boolean splitArray(int[] nums) {
        int n = nums.length;
        if (n < 7)
            return false;

        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        // Iterating on j as the middle split point
        for (int j = 3; j < n - 3; j++) {
            HashSet<Integer> set = new HashSet<>();

            // Search for i
            for (int i = 1; i < j - 1; i++) {
                int sum1 = prefixSum[i - 1];
                int sum2 = prefixSum[j - 1] - prefixSum[i];
                if (sum1 == sum2) {
                    set.add(sum1);
                }
            }

            // Search for k
            for (int k = j + 2; k < n - 1; k++) {
                int sum3 = prefixSum[k - 1] - prefixSum[j];
                int sum4 = prefixSum[n - 1] - prefixSum[k];
                if (sum3 == sum4 && set.contains(sum3)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_HashSet sol = new Solution_HashSet();
        int[] nums = { 1, 2, 1, 2, 1, 2, 1 };
        System.out.println("Can split: " + sol.splitArray(nums)); // Output: true
    }
}
