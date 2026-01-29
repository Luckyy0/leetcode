package leetcode.P506_RelativeRanks;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 506: Relative Ranks
     * Approach: Sorting indices based on scores
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     */
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        // Sort indices based on score descending
        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));

        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            int originalIdx = indices[i];
            if (i == 0) {
                res[originalIdx] = "Gold Medal";
            } else if (i == 1) {
                res[originalIdx] = "Silver Medal";
            } else if (i == 2) {
                res[originalIdx] = "Bronze Medal";
            } else {
                res[originalIdx] = String.valueOf(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [5,4,3,2,1] -> Gold, Silver, Bronze, 4, 5
        int[] s1 = { 5, 4, 3, 2, 1 };
        System.out.println("Result 1: " + Arrays.toString(sol.findRelativeRanks(s1)));

        // [10,3,8,9,4] -> Gold, 5, Bronze, Silver, 4
        int[] s2 = { 10, 3, 8, 9, 4 };
        System.out.println("Result 2: " + Arrays.toString(sol.findRelativeRanks(s2)));
    }
}
