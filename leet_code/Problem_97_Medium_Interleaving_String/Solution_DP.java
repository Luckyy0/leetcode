package leet_code.Problem_97_Medium_Interleaving_String;

public class Solution_DP {

    /**
     * Checks if s3 is an interleaving of s1 and s2.
     * Uses a 2D Dynamic Programming approach.
     * Kiểm tra xem s3 có phải là sự xen kẽ của s1 và s2 không.
     * Sử dụng phương pháp Quy hoạch động 2 chiều.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        if (n1 + n2 != n3) {
            return false;
        }

        // dp[i][j] means s3.substring(0, i+j) is interleaving of s1(0,i) and s2(0,j)
        // dp[i][j] có nghĩa là s3.substring(0, i+j) là sự xen kẽ của s1(0,i) và s2(0,j)
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    // Only from s2
                    // Chỉ lấy từ s2
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    // Only from s1
                    // Chỉ lấy từ s1
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    // Check if current s3 char matches s1[i-1] or s2[j-1]
                    // Kiểm tra xem ký tự s3 hiện tại có khớp với s1[i-1] hoặc s2[j-1] không
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                            (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }

        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("Test Case 1: " + solution.isInterleave(s1, s2, s3));
        // Expected: true

        // Test Case 2
        String s1_2 = "aabcc", s2_2 = "dbbca", s3_2 = "aadbbbaccc";
        System.out.println("Test Case 2: " + solution.isInterleave(s1_2, s2_2, s3_2));
        // Expected: false

        // Test Case 3
        System.out.println("Test Case 3: " + solution.isInterleave("", "", ""));
        // Expected: true
    }
}
