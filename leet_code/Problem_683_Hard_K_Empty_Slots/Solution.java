package leet_code.Problem_683_Hard_K_Empty_Slots;

import java.util.*;

public class Solution {

    /**
     * Finds the earliest day where two bulbs are on with exactly k off bulbs
     * between them.
     * Strategy: Transform to days[position] and use a sliding window.
     * Time: O(N), Space: O(N).
     */
    public int kEmptySlots(int[] bulbs, int k) {
        int n = bulbs.length;
        // days[i] = day when bulb at position i+1 turns on
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[bulbs[i] - 1] = i + 1;
        }

        int left = 0;
        int right = k + 1;
        int result = Integer.MAX_VALUE;

        // Slide window [left, right]
        for (int i = 1; right < n; i++) {
            // Check if every day in between is strictly GREATER than boundaries
            if (days[i] > days[left] && days[i] > days[right]) {
                continue;
            }

            // If we reached the right boundary, we found a valid window
            if (i == right) {
                result = Math.min(result, Math.max(days[left], days[right]));
            }

            // If day at i is not greater than boundaries, current window is invalid
            // Start a new window from current location i
            left = i;
            right = i + k + 1;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] bulbs1 = { 1, 3, 2 };
        System.out.println("Result (k=1): " + sol.kEmptySlots(bulbs1, 1)); // 2

        int[] bulbs2 = { 1, 2, 3 };
        System.out.println("Result (k=1): " + sol.kEmptySlots(bulbs2, 1)); // -1
    }
}
