package leet_code.Problem_833_Medium_Find_And_Replace_in_String;

import java.util.Arrays;

public class Solution {

    /**
     * Performs multiple find-and-replace operations simultaneously.
     * Strategy: Use a mapping array to mark valid replacements at their start
     * indices.
     * Time: O(N + K*L), Space: O(N + total_target_len).
     */
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        // match[i] stores the index of the replacement operation that starts at s[i]
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for (int i = 0; i < indices.length; i++) {
            int start = indices[i];
            String source = sources[i];

            // Check if the source string matches the original string s starting at 'start'
            if (s.startsWith(source, start)) {
                match[start] = i;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n;) {
            if (match[i] >= 0) {
                // If there is a match, replace the whole source string with the target
                int opIdx = match[i];
                result.append(targets[opIdx]);
                // Jump the current index forward by the length of the source substring removed
                i += sources[opIdx].length();
            } else {
                // Otherwise, keep the original character
                result.append(s.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "abcd";
        int[] i1 = { 0, 2 };
        String[] sc1 = { "a", "cd" };
        String[] t1 = { "eee", "ffff" };
        System.out.println("Result 1: " + sol.findReplaceString(s1, i1, sc1, t1));
        // Expect: eeebffff

        String s2 = "abcd";
        int[] i2 = { 0, 2 };
        String[] sc2 = { "ab", "ec" };
        String[] t2 = { "eee", "ffff" };
        System.out.println("Result 2: " + sol.findReplaceString(s2, i2, sc2, t2));
        // Expect: eeecd
    }
}
