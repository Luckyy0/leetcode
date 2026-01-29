package leetcode.P2063_VowelsOfAllSubstrings;

public class Solution {
    public long countVowels(String word) {
        long total = 0;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (isVowel(c)) {
                total += (long) (i + 1) * (n - i);
            }
        }
        return total;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
