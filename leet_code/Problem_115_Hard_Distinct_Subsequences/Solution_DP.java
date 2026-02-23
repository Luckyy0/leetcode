package leet_code.Problem_115_Hard_Distinct_Subsequences;

public class Solution_DP {

    /**
     * Finds the number of distinct subsequences of s that equal t.
     * Uses 2D Dynamic Programming.
     * 
     * Tìm số lượng các chuỗi con phân biệt của s mà bằng t.
     * Sử dụng Quy hoạch động 2 chiều.
     */
    public int numDistinct(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        // dp[i][j] represents number of ways to form t[0...i-1] from s[0...j-1]
        // dp[i][j] đại diện cho số cách tạo ra t[0...i-1] từ s[0...j-1]
        int[][] dp = new int[tlen + 1][slen + 1];

        // Base Case: If t is empty, there is 1 way (delete all chars in s)
        // Trường hợp cơ sở: Nếu t trống, có 1 cách (xóa tất cả các ký tự trong s)
        for (int j = 0; j <= slen; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table
        // Điền vào bảng DP
        for (int i = 1; i <= tlen; i++) {
            for (int j = 1; j <= slen; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    // Match found:
                    // 1. Use s[j-1] to match t[i-1]: ways = dp[i-1][j-1]
                    // 2. Do not use s[j-1]: ways = dp[i][j-1]
                    // Nếu khớp:
                    // 1. Sử dụng s[j-1] để khớp t[i-1]: số cách = dp[i-1][j-1]
                    // 2. Không sử dụng s[j-1]: số cách = dp[i][j-1]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    // Match not found:
                    // Must skip s[j-1]: ways = dp[i][j-1]
                    // Nếu không khớp:
                    // Phải bỏ qua s[j-1]: số cách = dp[i][j-1]
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[tlen][slen];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: "rabbbit", "rabbit"
        System.out.println("Test Case 1: " + solution.numDistinct("rabbbit", "rabbit"));
        // Expected: 3

        // Test Case 2: "babgbag", "bag"
        System.out.println("Test Case 2: " + solution.numDistinct("babgbag", "bag"));
        // Expected: 5
    }
}
