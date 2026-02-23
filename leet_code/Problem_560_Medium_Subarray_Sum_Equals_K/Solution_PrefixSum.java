package leet_code.Problem_560_Medium_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

public class Solution_PrefixSum {

    /**
     * Finds total number of subarrays whose sum equals k.
     * Strategy: Prefix Sum with HashMap.
     * Time: O(N), Space: O(N).
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        // Map to store prefix sum frequencies
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        // Base case: prefix sum of 0 has occurred once
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) occurred before, there's a subarray summing to k
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k);
            }

            // Record the current prefix sum in the map
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_PrefixSum solution = new Solution_PrefixSum();
        int[] nums1 = { 1, 1, 1 };
        System.out.println("Result [1,1,1], k=2: " + solution.subarraySum(nums1, 2)); // 2

        int[] nums2 = { 1, 2, 3 };
        System.out.println("Result [1,2,3], k=3: " + solution.subarraySum(nums2, 3)); // 2
    }
}
