package leet_code.Problem_801_Hard_Minimum_Swaps_To_Make_Sequences_Increasing;

import java.util.Arrays;

public class Solution {

    /**
     * Calculates the minimum swaps to make both sequences strictly increasing.
     * Strategy: Dynamic Programming with two states (keep and swap).
     * Time: O(N), Space: O(1).
     */
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // n1: min swaps up to current index if we do NOT swap at current index
        // s1: min swaps up to current index if we DO swap at current index
        int n1 = 0, s1 = 1;

        for (int i = 1; i < n; i++) {
            // New states for index i
            int n2 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

            // Case 1: Elements are already increasing without a cross-swap
            // nums1[i-1] < nums1[i] and nums2[i-1] < nums2[i]
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                // Choice at i matches choice at i-1
                n2 = Math.min(n2, n1);
                s2 = Math.min(s2, s1 + 1);
            }

            // Case 2: Elements are increasing if we perform a cross-swap
            // nums1[i-1] < nums2[i] and nums2[i-1] < nums1[i]
            if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                // Choice at i is opposite to choice at i-1
                n2 = Math.min(n2, s1);
                s2 = Math.min(s2, n1 + 1);
            }

            // Move to next step
            n1 = n2;
            s1 = s2;
        }

        return Math.min(n1, s1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a1 = { 1, 3, 5, 4 }, b1 = { 1, 2, 3, 7 };
        System.out.println("Result 1: " + sol.minSwap(a1, b1)); // 1

        int[] a2 = { 0, 3, 5, 8, 9 }, b2 = { 2, 1, 4, 6, 9 };
        System.out.println("Result 2: " + sol.minSwap(a2, b2)); // 1
    }
}
