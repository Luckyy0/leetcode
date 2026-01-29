package leetcode.P1163_LastSubstringInLexicographicalOrder;

class Solution {
    public String lastSubstring(String s) {
        int i = 0, j = 1, k = 0, n = s.length();

        while (j + k < n) {
            if (s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            } else if (s.charAt(i + k) < s.charAt(j + k)) {
                // j is better. i jumps past j+k? No, i jumps to at least j.
                // Actually i jumps to max(i + k + 1, j).
                // Because i...i+k is strictly worse prefix than j...j+k.
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            } else {
                // i is better. j jumps past j+k.
                j = j + k + 1;
                k = 0;
            }
        }

        return s.substring(i);
    }
}
