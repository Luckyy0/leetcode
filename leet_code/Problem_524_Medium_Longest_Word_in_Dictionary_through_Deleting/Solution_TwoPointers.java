package leet_code.Problem_524_Medium_Longest_Word_in_Dictionary_through_Deleting;

import java.util.List;

public class Solution_TwoPointers {

    /**
     * Finds longest word in dictionary that is subsequence of s.
     * Strategy: Linear scan with two-pointers subsequence check.
     * Time: O(N * S), Space: O(1).
     */
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";

        for (String target : dictionary) {
            // Check if better length or lexicographically smaller
            // Optimization: If target is shorter than current result, skip?
            // Yes, if target.length() < result.length(), no need to check.
            // If equal length, only check if lexicographically smaller.
            if (target.length() < result.length() ||
                    (target.length() == result.length() && target.compareTo(result) > 0)) {
                continue;
            }

            if (isSubsequence(s, target)) {
                result = target;
            }
        }

        return result;
    }

    private boolean isSubsequence(String s, String target) {
        if (target.length() > s.length())
            return false;

        int i = 0; // index for s
        int j = 0; // index for target

        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == target.length();
    }

    public static void main(String[] args) {
        Solution_TwoPointers solution = new Solution_TwoPointers();
        String s = "abpcplea";
        List<String> dictionary = List.of("ale", "apple", "monkey", "plea");
        System.out.println("Result: " + solution.findLongestWord(s, dictionary)); // "apple"
    }
}
