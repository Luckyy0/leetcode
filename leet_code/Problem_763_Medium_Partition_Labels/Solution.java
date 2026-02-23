package leet_code.Problem_763_Medium_Partition_Labels;

import java.util.*;

public class Solution {

    /**
     * Partitions string into parts where each char appears in at most one part.
     * Strategy: Greedy approach using last occurrence map.
     * Time: O(N), Space: O(1).
     */
    public List<Integer> partitionLabels(String s) {
        // Precompute the last index of each character
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Update the furthest end point required by current character
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // If we reached the required end, this partition is complete
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.partitionLabels("ababcbacadefegdehijhklij"));
        // [9, 7, 8]
        System.out.println("Result 2: " + sol.partitionLabels("eccbbbbdec"));
        // [10]
    }
}
