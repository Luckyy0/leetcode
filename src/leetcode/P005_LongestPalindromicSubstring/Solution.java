package leetcode.P005_LongestPalindromicSubstring;

public class Solution {

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^3) - TLE likely
     * Space Complexity: O(1)
     */
    public String longestPalindromeBruteForce(String s) {
        if (s == null || s.length() < 1)
            return "";
        int n = s.length();
        String maxStr = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxStr.length()) {
                        maxStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxStr;
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    /**
     * Approach 2: Expand Around Center (Optimal Space)
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public String longestPalindromeExpand(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length
            int len2 = expandAroundCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                // Determine new start and end based on center i and length
                // Tính toán start và end mới dựa trên tâm i và độ dài
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return length: (right - 1) - (left + 1) + 1 = right - left - 1
        return right - left - 1;
    }

    /**
     * Approach 3: Dynamic Programming
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() < 1)
            return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String maxStr = "";

        // Length 1 is always true
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (maxStr.length() == 0)
                maxStr = s.substring(i, i + 1);
        }

        // Loop for length from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                // Check if ends match
                if (s.charAt(i) == s.charAt(j)) {
                    // Check inner part: if len us 2, only need ends match
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxStr.length()) {
                            maxStr = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputs = {
                "babad", // Exp: "bab" or "aba"
                "cbbd", // Exp: "bb"
                "a", // Exp: "a"
                "ac", // Exp: "a" or "c"
                "racecar", // Exp: "racecar"
                "aaaa", // Exp: "aaaa"
                "" // Exp: ""
        };

        for (String s : inputs) {
            System.out.println("Input: \"" + s + "\"");

            String res1 = solution.longestPalindromeBruteForce(s);
            System.out.println("BruteForce: " + res1);

            String res2 = solution.longestPalindromeExpand(s);
            System.out.println("ExpandCenter: " + res2);

            String res3 = solution.longestPalindromeDP(s);
            System.out.println("DP: " + res3);

            // Basic verification
            if (res1.length() == res2.length() && res2.length() == res3.length()) {
                System.out.println("PASS (Lengths match)");
            } else {
                System.out.println("FAIL (Lengths mismatch)");
            }
            System.out.println("-------------------------");
        }
    }
}
