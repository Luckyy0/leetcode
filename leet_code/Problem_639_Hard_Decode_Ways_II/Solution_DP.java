package leet_code.Problem_639_Hard_Decode_Ways_II;

public class Solution_DP {

    /**
     * Finds the number of ways to decode a message with wildcards.
     * Strategy: DP with constant space and detailed case analysis for '*'.
     * Time: O(N), Space: O(1).
     */
    public int numDecodings(String s) {
        long MOD = 1000000007;

        // dp[i-2] and dp[i-1] represented by variables
        long prev2 = 1;
        long prev1 = waysToDecodeSingle(s.charAt(0));

        for (int i = 2; i <= s.length(); i++) {
            char curr = s.charAt(i - 1);
            char prev = s.charAt(i - 2);

            // Ways considering only the single current character
            long current = (waysToDecodeSingle(curr) * prev1) % MOD;

            // Ways considering the pair of (prev, curr)
            current = (current + waysToDecodePair(prev, curr) * prev2) % MOD;

            // Advance states
            prev2 = prev1;
            prev1 = current;
        }

        return (int) prev1;
    }

    private long waysToDecodeSingle(char c) {
        if (c == '*')
            return 9;
        if (c == '0')
            return 0;
        return 1;
    }

    private long waysToDecodePair(char c1, char c2) {
        if (c1 == '*') {
            if (c2 == '*') {
                // 11-19 (9) + 21-26 (6)
                return 15;
            } else if (c2 <= '6') {
                // 1x and 2x
                return 2;
            } else {
                // 1x
                return 1;
            }
        } else if (c1 == '1') {
            if (c2 == '*') {
                // 11-19
                return 9;
            } else {
                return 1;
            }
        } else if (c1 == '2') {
            if (c2 == '*') {
                // 21-26
                return 6;
            } else if (c2 <= '6') {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution_DP sol = new Solution_DP();
        System.out.println("Ways for '*': " + sol.numDecodings("*")); // 9
        System.out.println("Ways for '1*': " + sol.numDecodings("1*")); // 18
    }
}
