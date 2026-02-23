package leet_code.Problem_680_Easy_Valid_Palindrome_II;

public class Solution {

    /**
     * Checks if a string can become a palindrome after deleting at most one
     * character.
     * Strategy: Two pointers with a branch upon the first mismatch.
     * Time: O(N), Space: O(1).
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // If mismatch, we must delete either s[i] or s[j]
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }

        return true;
    }

    /**
     * Helper to check if a substring is a perfect palindrome.
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 'aba': " + sol.validPalindrome("aba")); // true
        System.out.println("Result 'abca': " + sol.validPalindrome("abca")); // true
        System.out.println("Result 'abc': " + sol.validPalindrome("abc")); // false
    }
}
