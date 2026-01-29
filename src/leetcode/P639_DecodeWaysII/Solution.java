package leetcode.P639_DecodeWaysII;

class Solution {
    public int numDecodings(String s) {
        int MOD = 1000000007;

        long prev = 1; // dp[i-2] (for i=0 -> "")
        long curr = helper(s.charAt(0)); // dp[i-1] (for i=1 -> first char)

        for (int i = 1; i < s.length(); i++) {
            long temp = curr;

            // 1-digit
            long oneDigit = helper(s.charAt(i));
            long ways = (oneDigit * curr) % MOD;

            // 2-digit
            long twoDigits = helper2(s.charAt(i - 1), s.charAt(i));
            ways = (ways + twoDigits * prev) % MOD;

            curr = ways;
            prev = temp;
        }

        return (int) curr;
    }

    // Ways to decode 1 char
    // Cách giải mã 1 ký tự
    private int helper(char c) {
        if (c == '*')
            return 9;
        if (c == '0')
            return 0;
        return 1;
    }

    // Ways to decode 2 chars c1c2
    // Cách giải mã 2 ký tự c1c2
    private int helper2(char c1, char c2) {
        if (c1 == '*') {
            if (c2 == '*') {
                return 15; // 11-19 (9), 21-26 (6) -> 15
            } else {
                // c1 is *, c2 is digit
                if (c2 <= '6')
                    return 2; // 1d, 2d (valid)
                else
                    return 1; // 1d (valid), 2d (invalid >26)
            }
        } else {
            // c1 is digit
            if (c1 == '1') {
                if (c2 == '*')
                    return 9; // 11-19
                else
                    return 1; // 1d is always valid 10-19
            } else if (c1 == '2') {
                if (c2 == '*')
                    return 6; // 21-26
                else if (c2 <= '6')
                    return 1; // 20-26
                else
                    return 0; // 27-29 invalid
            } else {
                return 0; // 3x..9x invalid
            }
        }
    }
}
