package leetcode.P1392_LongestHappyPrefix;

class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int j = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        int len = lps[n - 1];
        return s.substring(0, len);
    }
}
