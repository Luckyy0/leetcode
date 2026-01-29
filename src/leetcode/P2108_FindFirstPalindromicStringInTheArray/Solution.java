package leetcode.P2108_FindFirstPalindromicStringInTheArray;

public class Solution {
    public String firstPalindrome(String[] words) {
        for (String w : words) {
            if (isPalindrome(w))
                return w;
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}
