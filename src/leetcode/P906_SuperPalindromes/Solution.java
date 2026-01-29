package leetcode.P906_SuperPalindromes;

class Solution {
    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int count = 0;

        // Generate palindromes with length up to 9 digits (P < 10^9)
        // Part 1: Even length palindromes
        for (int i = 1; i < 100000; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 1; j >= 0; j--)
                sb.append(sb.charAt(j));
            long p = Long.parseLong(sb.toString());
            long v = p * p;
            if (v > R)
                break;
            if (v >= L && isPalindrome(v))
                count++;
        }

        // Part 2: Odd length palindromes
        for (int i = 1; i < 100000; i++) {
            StringBuilder sb = new StringBuilder(Integer.toString(i));
            for (int j = sb.length() - 2; j >= 0; j--)
                sb.append(sb.charAt(j));
            long p = Long.parseLong(sb.toString());
            long v = p * p;
            if (v > R && sb.length() > 9)
                break; // Heuristic check
            if (v > R)
                continue;
            if (v >= L && isPalindrome(v))
                count++;
        }

        return count;
    }

    private boolean isPalindrome(long x) {
        String s = Long.toString(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
// Note: Optimized search required for full performance.
