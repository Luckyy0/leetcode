package leetcode.P214_ShortestPalindrome;

public class Solution {

    /**
     * Problem 214: Shortest Palindrome
     * Approach: KMP Algorithm (LPS Array)
     * 
     * Theoretical Basis:
     * - Find longest palindromic prefix using s + "#" + reverse(s).
     * - The last value of LPS array gives the length of this prefix.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int n = combined.length();
        int[] lps = new int[n];

        // Compute LPS array
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        int palindromeLen = lps[n - 1];
        String suffix = s.substring(palindromeLen);
        String prefix = new StringBuilder(suffix).reverse().toString();

        return prefix + s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "aacecaaa" -> "aaacecaaa"
        runTest(solution, "aacecaaa", "aaacecaaa");

        // "abcd" -> "dcbabcd"
        runTest(solution, "abcd", "dcbabcd");

        // "" -> ""
        runTest(solution, "", "");

        // "a" -> "a"
        runTest(solution, "a", "a");
    }

    private static void runTest(Solution s, String input, String expected) {
        String result = s.shortestPalindrome(input);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
