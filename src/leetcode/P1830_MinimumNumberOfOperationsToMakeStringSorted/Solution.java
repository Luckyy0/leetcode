package leetcode.P1830_MinimumNumberOfOperationsToMakeStringSorted;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int makeStringSorted(String s) {
        int n = s.length();
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        invFact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = modInverse(fact[i]);
        }

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int current = s.charAt(i) - 'a';

            // Count characters smaller than current
            long smaller = 0;
            for (int k = 0; k < current; k++) {
                smaller += freq[k];
            }

            // Calculate permutations: (n - 1 - i)! / (prod(freq!))
            // We need to multiply by 'smaller' because any of those could be the first char

            if (smaller > 0) {
                long num = fact[n - 1 - i]; // Factorial of remaining length
                long den = 1;
                for (int k = 0; k < 26; k++) {
                    den = (den * fact[freq[k]]) % MOD;
                }

                // (num / den) * smaller
                long term = (num * modInverse(den)) % MOD;
                term = (term * smaller) % MOD;

                ans = (ans + term) % MOD;
            }

            // Update freq for next iteration
            freq[current]--;
        }

        return (int) ans;
    }

    private long modInverse(long a) {
        return power(a, MOD - 2);
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
