package leetcode.P091_DecodeWays;

public class Solution {

    /**
     * Problem 91: Decode Ways
     * Approach: Dynamic Programming
     * Time Complexity: O(N)
     * Space Complexity: O(N) (can be optimized O(1))
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base case: empty string has 1 way
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            // Check single digit
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Check two digits
            if (i >= 2) {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "12", 2);
        runTest(solution, "226", 3);
        runTest(solution, "06", 0);
        runTest(solution, "10", 1);
        runTest(solution, "2101", 1);
    }

    private static void runTest(Solution s, String str, int expected) {
        System.out.println("Input: \"" + str + "\"");
        int result = s.numDecodings(str);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
