package leetcode.P1621_NumberOfSetsOfKNonOverlappingLineSegments;

import java.math.BigInteger;

public class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;
        // Formula: C(n + k - 1, 2k)
        int N = n + k - 1;
        int R = 2 * k;

        if (R > N)
            return 0;

        return combination(N, R, MOD);
    }

    // Calculates C(n, k) % mod
    private int combination(int n, int k, int mod) {
        if (k < 0 || k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;
        if (k > n / 2)
            k = n - k;

        long numerator = 1;
        for (int i = 0; i < k; i++) {
            numerator = (numerator * (n - i)) % mod;
        }

        long denominator = 1;
        for (int i = 1; i <= k; i++) {
            denominator = (denominator * i) % mod;
        }

        return (int) ((numerator * modInverse(denominator, mod)) % mod);
    }

    private long modInverse(long n, int mod) {
        return power(n, mod - 2, mod);
    }

    private long power(long x, int y, int mod) {
        long res = 1;
        x = x % mod;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % mod;
            y = y >> 1;
            x = (x * x) % mod;
        }
        return res;
    }
}
