package leet_code.Problem_821_Easy_Shortest_Distance_to_a_CHARACTER;

import java.util.Arrays;

public class Solution {

    /**
     * Calculates the shortest distance to character c for each index in s.
     * Strategy: Two-pass scanning (Left-to-Right and Right-to-Left).
     * Time: O(N), Space: O(1) extra.
     */
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        // Use a value large enough so i - prev doesn't overflow or cause issues
        int prev = -20000;

        // First pass: Find nearest 'c' to the left
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = i - prev;
        }

        // Second pass: Find nearest 'c' to the right and take the minimum
        prev = 20000;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + Arrays.toString(sol.shortestToChar("loveleetcode", 'e')));
        // [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

        System.out.println("Result 2: " + Arrays.toString(sol.shortestToChar("aaab", 'b')));
        // [3, 2, 1, 0]
    }
}
