package leet_code.Problem_72_Hard_Edit_Distance;

public class Solution_DP {

    /**
     * Finds the minimum edit distance between word1 and word2.
     * Uses Dynamic Programming.
     * Tìm khoảng cách chỉnh sửa tối thiểu giữa word1 và word2.
     * Sử dụng Quy hoạch động.
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] will be the edit distance between the first i characters of word1
        // and first j characters of word2.
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: transforming a string to an empty string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no operation needed for this position
                    // Các ký tự giống nhau, không cần thao tác nào cho vị trí này
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Operations:
                    // dp[i-1][j-1]: Replace (Thay thế)
                    // dp[i-1][j]: Delete (Xóa)
                    // dp[i][j-1]: Insert (Chèn)
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        System.out.println("Test Case 1: " + solution.minDistance("horse", "ros"));
        // Expected: 3

        // Test Case 2
        System.out.println("Test Case 2: " + solution.minDistance("intention", "execution"));
        // Expected: 5
    }
}
