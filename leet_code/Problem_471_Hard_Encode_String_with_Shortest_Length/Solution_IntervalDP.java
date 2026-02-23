package leet_code.Problem_471_Hard_Encode_String_with_Shortest_Length;

public class Solution_IntervalDP {

    /**
     * Encodes the string to its shortest length.
     * Strategy: Interval DP. dp[i][j] stores the shortest encoding for s[i...j].
     * Time: O(N^3) approx (substring ops can add overhead), Space: O(N^2 * N) for
     * string storage.
     */
    public String encode(String s) {
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();
        String[][] dp = new String[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                String substr = s.substring(i, j + 1);

                // Base initialization: no encoding or trivial encoding
                dp[i][j] = substr;
                if (len < 5)
                    continue; // Length < 5 cannot be shortened by "k[...]"

                // Strategy 1: Try splitting at every point
                for (int k = i; k < j; k++) {
                    String left = dp[i][k];
                    String right = dp[k + 1][j];
                    if (left.length() + right.length() < dp[i][j].length()) {
                        dp[i][j] = left + right;
                    }
                }

                // Strategy 2: Try compressing the whole substring
                // Find strict repetitions using (s+s).indexOf(s, 1) trick
                String doubled = substr + substr;
                int idx = doubled.indexOf(substr, 1);

                if (idx < substr.length()) {
                    String pattern = substr.substring(0, idx);
                    // Ensure the recursive part is also optimal!
                    // Here, the pattern corresponds to s[i ... i+idx-1]
                    // We must use the DP result for that range: dp[i][i+idx-1]
                    String patternEncoded = dp[i][i + idx - 1];
                    String candidate = (substr.length() / pattern.length()) + "[" + patternEncoded + "]";

                    if (candidate.length() < dp[i][j].length()) {
                        dp[i][j] = candidate;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Solution_IntervalDP solution = new Solution_IntervalDP();
        System.out.println("Result (aaa): " + solution.encode("aaa")); // aaa
        System.out.println("Result (aaaaa): " + solution.encode("aaaaa")); // 5[a]
        System.out.println("Result (aabcaabcd): " + solution.encode("aabcaabcd")); // 2[aabc]d
    }
}
