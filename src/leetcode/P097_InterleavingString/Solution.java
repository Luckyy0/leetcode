package leetcode.P097_InterleavingString;

public class Solution {

    /**
     * Problem 97: Interleaving String
     * Approach: Dynamic Programming
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        
        // Quick check: lengths must match
        if (m + n != l) {
            return false;
        }
        
        // dp[i][j] = true if s3[0..i+j-1] can be formed by interleaving s1[0..i-1] and s2[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        
        // Fill first row (using only s2)
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill first column (using only s1)
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill rest of the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Take from s1
                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                // Take from s2
                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                
                dp[i][j] = fromS1 || fromS2;
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "aabcc", "dbbca", "aadbbcbcac", true);
        runTest(solution, "aabcc", "dbbca", "aadbbbaccc", false);
        runTest(solution, "", "", "", true);
        runTest(solution, "a", "", "a", true);
    }
    
    private static void runTest(Solution s, String s1, String s2, String s3, boolean expected) {
        System.out.println("Input: s1=\"" + s1 + "\", s2=\"" + s2 + "\", s3=\"" + s3 + "\"");
        boolean result = s.isInterleave(s1, s2, s3);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");
        
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
