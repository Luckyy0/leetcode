package leet_code.Problem_525_Medium_Contiguous_Array;

import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {

    /**
     * Finds max length of contiguous subarray with equal 0s and 1s.
     * Strategy: Treat 0 as -1. Find subarray with sum 0 using Prefix Sum Map.
     * Time: O(N), Space: O(N).
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        // Initialize for subarrays starting from index 0
        map.put(0, -1);

        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 1 ? 1 : -1);

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        int[] nums = { 0, 1, 0 };
        System.out.println("Result: " + solution.findMaxLength(nums)); // 2
    }
}
