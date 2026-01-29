package leetcode.P1446_ConsecutiveCharacters;

class Solution {
    public int maxPower(String s) {
        int maxLen = 1;
        int currentLen = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }
}
