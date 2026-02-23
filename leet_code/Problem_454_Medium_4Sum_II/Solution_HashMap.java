package leet_code.Problem_454_Medium_4Sum_II;

import java.util.*;

public class Solution_HashMap {

    /**
     * Counts the number of tuples from 4 arrays that sum to 0.
     * Strategy: Store sums of (nums1, nums2) in a map, then query with -(nums3 +
     * nums4).
     * Time: O(N^2), Space: O(N^2).
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Sums of pairs from first two arrays
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Match against sums of pairs from last two arrays
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += map.getOrDefault(target, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution_HashMap solution = new Solution_HashMap();
        int[] n1 = { 1, 2 }, n2 = { -2, -1 }, n3 = { -1, 2 }, n4 = { 0, 2 };
        System.out.println("Result: " + solution.fourSumCount(n1, n2, n3, n4)); // 2
    }
}
