package leetcode.P634_FindTheDerangementOfAnArray;

class Solution {
    public int findDerangement(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        long dp1 = 0; // represent D(n-2) initially D(1)
        long dp2 = 1; // represent D(n-1) initially D(2)
        long res = 0;
        int MOD = 1000000007;

        for (int i = 3; i <= n; i++) {
            // D(i) = (i - 1) * (D(i-1) + D(i-2))
            res = ((i - 1) * (dp1 + dp2)) % MOD;
            dp1 = dp2;
            dp2 = res;
        }

        return (int) dp2;
    }
}
