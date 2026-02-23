package leet_code.Problem_132_Hard_Palindrome_Partitioning_II;

public class Solution_DP {

    /**
     * Finds the minimum cuts needed for a palindrome partitioning of s.
     * Uses double Dynamic Programming for O(N^2) complexity.
     * 
     * Tìm số lần cắt tối thiểu cần thiết để phân tách chuỗi đối xứng của s.
     * Sử dụng Quy hoạch động kép với độ phức tạp O(N^2).
     */
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int n = s.length();

        // Step 1: Precompute palindrome table
        // Bước 1: Tính toán trước bảng chuỗi đối xứng
        boolean[][] isPal = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }
            }
        }

        // Step 2: Compute minimum cuts
        // Bước 2: Tính toán số lần cắt tối thiểu
        int[] minCuts = new int[n];
        for (int i = 0; i < n; i++) {
            // Case: The whole prefix s[0...i] is a palindrome
            // Trường hợp: Toàn bộ tiền tố s[0...i] là một chuỗi đối xứng
            if (isPal[0][i]) {
                minCuts[i] = 0;
            } else {
                // Initialize to maximum possible cuts
                // Khởi tạo giá trị cắt tối đa có thể
                minCuts[i] = i;
                for (int j = 1; j <= i; j++) {
                    // If s[j...i] is a palindrome, check if s[0...j-1] cuts + 1 is smaller
                    // Nếu s[j...i] là đối xứng, kiểm tra xem số lần cắt của s[0...j-1] + 1 có nhỏ
                    // hơn không
                    if (isPal[j][i]) {
                        minCuts[i] = Math.min(minCuts[i], minCuts[j - 1] + 1);
                    }
                }
            }
        }

        return minCuts[n - 1];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: "aab"
        System.out.println("Test Case 1: " + solution.minCut("aab"));
        // Expected: 1

        // Test Case 2: "a"
        System.out.println("Test Case 2: " + solution.minCut("a"));
        // Expected: 0

        // Test Case 3: "ab"
        System.out.println("Test Case 3: " + solution.minCut("ab"));
        // Expected: 1
    }
}
