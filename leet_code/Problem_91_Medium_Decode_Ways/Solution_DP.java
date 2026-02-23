package leet_code.Problem_91_Medium_Decode_Ways;

public class Solution_DP {

    /**
     * Returns the number of ways to decode string s.
     * Uses dynamic programming to count configurations.
     * Trả về số cách để giải mã chuỗi s.
     * Sử dụng quy hoạch động để đếm các cấu hình.
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        // dp[i] contains number of ways to decode prefix of length i
        // dp[i] chứa số cách giải mã chuỗi con tiền tố độ dài i
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case for empty string
        dp[1] = 1; // We already checked s.charAt(0) != '0'

        for (int i = 2; i <= n; i++) {
            // Check single digit
            // Kiểm tra một chữ số
            int singleDigit = Integer.parseInt(s.substring(i - 1, i));
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            // Check two digits
            // Kiểm tra hai chữ số
            int doubleDigit = Integer.parseInt(s.substring(i - 2, i));
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: "12"
        System.out.println("Test Case 1: " + solution.numDecodings("12"));
        // Expected: 2 (AB, L)

        // Test Case 2: "226"
        System.out.println("Test Case 2: " + solution.numDecodings("226"));
        // Expected: 3 (BZ, VF, BBF)

        // Test Case 3: "06"
        System.out.println("Test Case 3: " + solution.numDecodings("06"));
        // Expected: 0
    }
}
