package leetcode.P1328_BreakAPalindrome;

class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1)
            return "";

        char[] chars = palindrome.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }

        // If all 'a' in first half (e.g. "aa", "aba"), change last char to 'b'
        chars[n - 1] = 'b';
        return new String(chars);
    }
}
