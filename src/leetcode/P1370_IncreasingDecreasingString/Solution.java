package leetcode.P1370_IncreasingDecreasingString;

class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        while (sb.length() < n) {
            // Smaller to Larger
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    sb.append((char) ('a' + i));
                    freq[i]--;
                }
            }

            // Larger to Smaller
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    sb.append((char) ('a' + i));
                    freq[i]--;
                }
            }
        }

        return sb.toString();
    }
}
