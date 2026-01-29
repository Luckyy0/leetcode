package leetcode.P1411_NumberOfWaysToPaintNx3Grid;

class Solution {
    public int numOfWays(int n) {
        long a = 6; // ABC pattern (3 colors)
        long b = 6; // ABA pattern (2 colors)
        long MOD = 1_000_000_007;

        for (int i = 2; i <= n; i++) {
            long newA = (2 * a + 2 * b) % MOD;
            long newB = (2 * a + 3 * b) % MOD;
            a = newA;
            b = newB;
        }

        return (int) ((a + b) % MOD);
    }
}
