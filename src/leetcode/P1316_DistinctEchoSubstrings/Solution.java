package leetcode.P1316_DistinctEchoSubstrings;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> result = new HashSet<>();

        // Iterating length of 'A' (half of echo)
        // Optimization: checking substring equality.
        // O(N^2) approach without hashing using simple check?
        // Java String.equals is fast if strings differ early.
        // But worst case O(N^3). N <= 2000. 2000^3 is too big.
        // Rolling hash is needed.

        long BASE = 29L;
        long MOD = 1_000_000_007L;
        long[] hash = new long[n + 1];
        long[] power = new long[n + 1];

        power[0] = 1;
        for (int i = 1; i <= n; i++) {
            hash[i] = (hash[i - 1] * BASE + (text.charAt(i - 1) - 'a' + 1)) % MOD;
            power[i] = (power[i - 1] * BASE) % MOD;
        }

        for (int len = 1; len <= n / 2; len++) {
            // Check adjacent blocks of length 'len'
            // s[i...i+len-1] and s[i+len...i+2len-1]
            // Calculate hash and check equality often results in collisions for single
            // hash.
            // But problem usually accepts standard hashing.
            // Using HashSet of Strings ensures correctness but might be slow if many
            // collisions.
            // Let's rely on Hash for fast check, then add String to Set.
            int count = 0;
            for (int i = 0; i <= n - 2 * len; i++) {
                int j = i + len;
                long h1 = getHash(hash, power, i, i + len - 1, MOD);
                long h2 = getHash(hash, power, j, j + len - 1, MOD);

                if (h1 == h2) {
                    // Potential match.
                    // For absolute correctness, create substring and add to Set.
                    // The Set handles "distinct".
                    // Double check with substring equals if strict.
                    // With good modulo, collision is rare.
                    // But here we need distinct substrings.
                    // If we just store hashes, collisions might merge different strings.
                    // With N=2000, 29/1e9+7 is generally fine.
                    // Let's add actual substring to set to handle distinctness exactly.
                    // But if h1 == h2 check passes, we create string.
                    // To optimize, maybe skip string creation if hash already in set (of hashes)?
                    // But same hash could be different strings.

                    // Actually, for N=2000, Set<String> is fine if we only add when hash matches.
                    // But hash match for adjacent blocks is condition for being ECHO.
                    // We need to count distinct *whole echo strings* (length 2*len).

                    // If hash matches, it IS an echo substring (with high prob).
                    // We add `text.substring(i, i + 2 * len)` to result.
                    // But we can optimize: just verify characters if hashes match.
                    if (isEqual(text, i, j, len)) {
                        result.add(text.substring(i, i + 2 * len));
                    }
                }
            }
        }

        return result.size();
    }

    private long getHash(long[] hash, long[] power, int l, int r, long MOD) {
        return (hash[r + 1] - hash[l] * power[r - l + 1] % MOD + MOD) % MOD;
    }

    private boolean isEqual(String text, int i, int j, int len) {
        // Safe check to avoid hash collision issues
        for (int k = 0; k < len; k++) {
            if (text.charAt(i + k) != text.charAt(j + k))
                return false;
        }
        return true;
    }
}
