package leetcode.P1839_LongestSubstringOfAllVowelsInOrder;

public class Solution {
    public int longestBeautifulSubstring(String word) {
        int n = word.length();
        if (n < 5)
            return 0;

        int maxLen = 0;
        int currentLen = 1;
        int distinct = 1;

        for (int i = 1; i < n; i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) {
                currentLen++;
                if (word.charAt(i) > word.charAt(i - 1)) {
                    distinct++;
                }
            } else {
                currentLen = 1;
                distinct = 1;
            }

            if (distinct == 5) {
                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }
}
