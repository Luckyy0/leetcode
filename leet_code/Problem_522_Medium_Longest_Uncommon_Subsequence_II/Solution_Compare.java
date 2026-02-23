package leet_code.Problem_522_Medium_Longest_Uncommon_Subsequence_II;

import java.util.Arrays;

public class Solution_Compare {

    /**
     * Finds LUS II.
     * Strategy: Sort by length desc. Check if current string is subsequence of any
     * other.
     * Time: O(N^2 * L), Space: O(1).
     */
    public int findLUSlength(String[] strs) {
        // Sort by length descending
        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        for (int i = 0; i < strs.length; i++) {
            boolean isSubseq = false;
            for (int j = 0; j < strs.length; j++) {
                if (i == j)
                    continue;
                if (isSubsequence(strs[i], strs[j])) {
                    isSubseq = true;
                    break;
                }
            }
            if (!isSubseq) {
                return strs[i].length();
            }
        }

        return -1;
    }

    // Check if a is a subsequence of b
    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }

    public static void main(String[] args) {
        Solution_Compare solution = new Solution_Compare();
        String[] strs = { "aba", "cdc", "eae" };
        System.out.println("Result: " + solution.findLUSlength(strs)); // 3
    }
}
