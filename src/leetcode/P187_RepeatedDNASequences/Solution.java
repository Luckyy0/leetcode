package leetcode.P187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    /**
     * Problem 187: Repeated DNA Sequences
     * Approach: Two HashSets for tracking seen and repeated substrings
     * 
     * Theoretical Basis:
     * - We slide a window of length 10 through the string.
     * - 'seen' set tracks all unique substrings encountered.
     * - 'repeated' set tracks substrings that appear at least twice.
     * 
     * Time Complexity: O(N * L) where N is length of s and L = 10.
     * Space Complexity: O(N * L) to store the substrings in the sets.
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {
                repeated.add(sub);
            }
        }

        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("Test 1: " + solution.findRepeatedDnaSequences(s1));
        // Expected: [AAAAACCCCC, CCCCCAAAAA] (any order)

        // Example 2
        String s2 = "AAAAAAAAAAAAA";
        System.out.println("Test 2: " + solution.findRepeatedDnaSequences(s2));
        // Expected: [AAAAAAAAAA]

        // Short string
        String s3 = "ACGT";
        System.out.println("Test 3: " + solution.findRepeatedDnaSequences(s3));
        // Expected: []
    }
}
