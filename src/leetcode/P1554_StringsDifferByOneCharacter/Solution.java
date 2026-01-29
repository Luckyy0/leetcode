package leetcode.P1554_StringsDifferByOneCharacter;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean differByOne(String[] dict) {
        if (dict == null || dict.length < 2) {
            return false;
        }

        int n = dict.length;
        int m = dict[0].length();

        long[] h = new long[n];
        long mod = (long) 1e11 + 7;
        long base = 26;
        long[] power = new long[m];

        // Precompute powers
        power[m - 1] = 1;
        for (int i = m - 2; i >= 0; i--) {
            power[i] = (power[i + 1] * base) % mod;
        }

        // Compute full hashes
        for (int i = 0; i < n; i++) {
            long val = 0;
            for (int j = 0; j < m; j++) {
                val = (val * base + (dict[i].charAt(j) - 'a')) % mod;
            }
            h[i] = val;
        }

        // Check for each position
        for (int j = 0; j < m; j++) {
            Set<Long> seen = new HashSet<>();
            for (int i = 0; i < n; i++) {
                // To remove character at index j:
                // Original: ... + c[j]*P[j] + ...
                // New: Original - c[j]*P[j]
                long newVal = (h[i] - (dict[i].charAt(j) - 'a') * power[j]) % mod;
                if (newVal < 0)
                    newVal += mod;

                if (seen.contains(newVal)) {
                    return true;
                }
                seen.add(newVal);
            }
        }

        return false;
    }
}
