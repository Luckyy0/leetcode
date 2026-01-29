package leetcode.P1680_ConcatenationOfConsecutiveBinaryNumbers;

public class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int MOD = 1_000_000_007;
        int bitLen = 0;

        for (int i = 1; i <= n; i++) {
            // Check if i is a power of 2 to increment bit length
            if ((i & (i - 1)) == 0) {
                bitLen++;
            }

            res = ((res << bitLen) + i) % MOD;
        }

        return (int) res;
    }
}
