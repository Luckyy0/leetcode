package leet_code.Problem_697_Easy_Degree_of_an_Array;

import java.util.*;

public class Solution {

    /**
     * Finds the minimum length of a subarray with the same degree as the whole
     * array.
     * Strategy: Track frequency, first index, and last index for each number.
     * Time: O(N), Space: O(N).
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            // Record first occurrence
            if (!first.containsKey(x)) {
                first.put(x, i);
            }
            // Record last occurrence
            last.put(x, i);
            // Increment frequency and update degree
            count.put(x, count.getOrDefault(x, 0) + 1);
            degree = Math.max(degree, count.get(x));
        }

        int minLength = nums.length;
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                // For each element that contributes to the degree, calculate span
                minLength = Math.min(minLength, last.get(x) - first.get(x) + 1);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 2, 2, 3, 1 };
        System.out.println("Result 1: " + sol.findShortestSubArray(nums1)); // 2

        int[] nums2 = { 1, 2, 2, 3, 1, 4, 2 };
        System.out.println("Result 2: " + sol.findShortestSubArray(nums2)); // 6
    }
}
