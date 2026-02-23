package leet_code.Problem_647_Medium_Palindromic_Substrings;

public class Solution_Expansion {

    /**
     * Counts the total number of palindromic substrings.
     * Strategy: Expand from each possible center (single char or gap between
     * chars).
     * Time: O(N^2), Space: O(1).
     */
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // Odd length palindromes (center is at i)
            count += expand(s, i, i);
            // Even length palindromes (center is between i and i+1)
            count += expand(s, i, i + 1);
        }

        return count;
    }

    /**
     * Helper to expand outward from a center and count palindromes.
     */
    private int expand(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution_Expansion sol = new Solution_Expansion();
        System.out.println("Count for 'abc': " + sol.countSubstrings("abc")); // 3
        System.out.println("Count for 'aaa': " + sol.countSubstrings("aaa")); // 6
    }
}
