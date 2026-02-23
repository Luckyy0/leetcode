package leet_code.Problem_10_Hard_Regular_Expression_Matching;

public class Solution_DP {

    /**
     * Implements Regular Expression Matching using Dynamic Programming.
     * Time Complexity: O(M * N), Space Complexity: O(M * N).
     * Triển khai Khớp Biểu Thức Chính Quy sử dụng Quy hoạch động.
     * Độ phức tạp thời gian: O(M * N), Độ phức tạp không gian: O(M * N).
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        // dp[i][j] means if s[0...i-1] matches p[0...j-1]
        // dp[i][j] có nghĩa là nếu s[0...i-1] khớp với p[0...j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty matches empty
        // Trường hợp cơ sở: rỗng khớp với rỗng
        dp[0][0] = true;

        // Initialize for pattern matching empty string (e.g., "a*", "a*b*")
        // Khởi tạo cho mẫu khớp với chuỗi rỗng (ví dụ: "a*", "a*b*")
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // Takes the value from skipping the char-star pair
                // Lấy giá trị từ việc bỏ qua cặp ký tự-sao
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == sChar || pChar == '.') {
                    // Current characters match, inherit from previous diagonal
                    // Các ký tự hiện tại khớp, kế thừa từ đường chéo trước đó
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar == '*') {
                    char pPrev = p.charAt(j - 2);

                    // Two situations:
                    // 1. '*' counts as zero of the preceding element -> look at dp[i][j-2]
                    // 2. '*' counts as one or more -> precede must match sChar (or be '.') AND
                    // dp[i-1][j] is true
                    // Hai tình huống:
                    // 1. '*' tính là không có phần tử đứng trước -> nhìn vào dp[i][j-2]
                    // 2. '*' tính là một hoặc nhiều -> phần tử đứng trước phải khớp sChar (hoặc là
                    // '.') VÀ dp[i-1][j] là đúng
                    boolean matchZero = dp[i][j - 2];
                    boolean matchOneOrMore = (pPrev == sChar || pPrev == '.') && dp[i - 1][j];

                    dp[i][j] = matchZero || matchOneOrMore;
                } else {
                    // Characters don't match and no '*' involved
                    // Các ký tự không khớp và không liên quan đến '*'
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1
        String s1 = "aa";
        String p1 = "a";
        System.out.println("Test Case 1: " + solution.isMatch(s1, p1));
        // Expected: false

        // Test Case 2
        String s2 = "aa";
        String p2 = "a*";
        System.out.println("Test Case 2: " + solution.isMatch(s2, p2));
        // Expected: true

        // Test Case 3
        String s3 = "ab";
        String p3 = ".*";
        System.out.println("Test Case 3: " + solution.isMatch(s3, p3));
        // Expected: true

        // Test Case 4: Complex
        String s4 = "aab";
        String p4 = "c*a*b";
        System.out.println("Test Case 4: " + solution.isMatch(s4, p4));
        // Expected: true
    }
}
