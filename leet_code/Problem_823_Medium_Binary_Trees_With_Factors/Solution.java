package leet_code.Problem_823_Medium_Binary_Trees_With_Factors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Counts the number of factored binary trees.
     * Strategy: DP after sorting the array. dp[x] = 1 + sum(dp[a] * dp[b]) for all
     * a*b = x.
     * Time: O(N^2), Space: O(N).
     */
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = 1_000_000_007;
        int n = arr.length;

        // Sorting helps ensure we process smaller numbers (potential children) first
        Arrays.sort(arr);

        // dp[val] stores the number of trees with root 'val'
        Map<Integer, Long> dp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            // Base case: a single node tree with current value
            long count = 1L;

            // Look for pairs (arr[j], right) such that arr[j] * right = current
            // Since array is sorted, children must be at indices j < i
            for (int j = 0; j < i; j++) {
                int left = arr[j];

                // If left is a factor
                if (current % left == 0) {
                    int right = current / left;

                    // Check if the other factor (right part) also exists in the array
                    if (dp.containsKey(right)) {
                        // All trees with root 'left' combined with all trees with root 'right'
                        count = (count + dp.get(left) * dp.get(right)) % mod;
                    }
                }
            }
            dp.put(current, count);
        }

        long totalResult = 0;
        for (long val : dp.values()) {
            totalResult = (totalResult + val) % mod;
        }

        return (int) totalResult;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a1 = { 2, 4 };
        System.out.println("Result 1: " + sol.numFactoredBinaryTrees(a1)); // 3

        int[] a2 = { 2, 4, 5, 10 };
        System.out.println("Result 2: " + sol.numFactoredBinaryTrees(a2)); // 7
    }
}
