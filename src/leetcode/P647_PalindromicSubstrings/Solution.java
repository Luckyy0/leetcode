package leetcode.P647_PalindromicSubstrings;

class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            // Odd length palindromes centered at i
            // Palindrome độ dài lẻ tập trung tại i
            count += expand(s, i, i);

            // Even length palindromes centered at i, i+1
            // Palindrome độ dài chẵn tập trung tại i, i+1
            count += expand(s, i, i + 1);
        }

        return count;
    }

    private int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
