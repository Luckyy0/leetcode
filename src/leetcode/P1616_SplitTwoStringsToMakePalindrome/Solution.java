package leetcode.P1616_SplitTwoStringsToMakePalindrome;

public class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {
        int left = 0;
        int right = a.length() - 1;

        // Greedily match prefix of a with suffix of b
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }

        // If pointers crossed or met, it's already a palindrome
        if (left >= right)
            return true;

        // Check if the remaining middle part of a OR b is a palindrome
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
