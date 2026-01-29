package leetcode.P1987_NumberOfUniqueGoodSubsequences;

public class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        int MOD = 1_000_000_007;
        long dp0 = 0, dp1 = 0;
        boolean hasZero = false;

        for (char c : binary.toCharArray()) {
            if (c == '0') {
                hasZero = true;
                dp0 = (dp0 + dp1) % MOD;
            } else {
                dp1 = (dp0 + dp1 + 1) % MOD;
            }
        }

        long ans = (dp0 + dp1 + (hasZero ? 1 : 0)) % MOD;
        return (int) ans;
    }
}
