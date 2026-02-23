package leet_code.Problem_659_Medium_Split_Array_into_Consecutive_Subsequences;

import java.util.*;

public class Solution_Greedy {

    /**
     * Determines if nums can be split into consecutive subsequences of length >= 3.
     * Strategy: Greedy with frequency and expectation (needs) maps.
     * Time: O(N), Space: O(N).
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> needs = new HashMap<>(); // How many sequences end at x-1 and need x

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int n : nums) {
            if (freq.get(n) == 0)
                continue;

            // Priority 1: Try to append n to an existing sequence
            if (needs.getOrDefault(n, 0) > 0) {
                freq.put(n, freq.get(n) - 1);
                needs.put(n, needs.get(n) - 1);
                needs.put(n + 1, needs.getOrDefault(n + 1, 0) + 1);
            }
            // Priority 2: Try to start a new sequence of length 3: [n, n+1, n+2]
            else if (freq.getOrDefault(n + 1, 0) > 0 && freq.getOrDefault(n + 2, 0) > 0) {
                freq.put(n, freq.get(n) - 1);
                freq.put(n + 1, freq.get(n + 1) - 1);
                freq.put(n + 2, freq.get(n + 2) - 1);
                // This sequence now needs n+3
                needs.put(n + 3, needs.getOrDefault(n + 3, 0) + 1);
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Greedy sol = new Solution_Greedy();
        int[] nums1 = { 1, 2, 3, 3, 4, 5 };
        System.out.println("Result 1: " + sol.isPossible(nums1)); // true
        int[] nums2 = { 1, 2, 3, 4, 4, 5 };
        System.out.println("Result 2: " + sol.isPossible(nums2)); // false
    }
}
