package leetcode.P1923_LongestCommonSubpath;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static final long MOD1 = 1_000_000_007;
    private static final long BASE1 = 100003;
    private static final long MOD2 = 1_000_000_009;
    private static final long BASE2 = 100019;

    public int longestCommonSubpath(int n, int[][] paths) {
        int minLen = Integer.MAX_VALUE;
        for (int[] p : paths)
            minLen = Math.min(minLen, p.length);

        int low = 1, high = minLen;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(paths, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int[][] paths, int len) {
        Set<Long> commonHashes = null;

        long pow1 = 1;
        long pow2 = 1;
        for (int i = 0; i < len - 1; i++) {
            pow1 = (pow1 * BASE1) % MOD1;
            pow2 = (pow2 * BASE2) % MOD2;
        }

        for (int[] p : paths) {
            Set<Long> currentHashes = new HashSet<>();
            long h1 = 0;
            long h2 = 0;

            for (int i = 0; i < p.length; i++) {
                h1 = (h1 * BASE1 + p[i]) % MOD1;
                h2 = (h2 * BASE2 + p[i]) % MOD2;

                if (i >= len) {
                    long remove1 = (p[i - len] * pow1) % MOD1;
                    h1 = (h1 - remove1 + MOD1) % MOD1;
                    long remove2 = (p[i - len] * pow2) % MOD2;
                    h2 = (h2 - remove2 + MOD2) % MOD2;
                }

                if (i >= len - 1) {
                    currentHashes.add((h1 << 32) | h2);
                }
            }

            if (commonHashes == null) {
                commonHashes = currentHashes;
            } else {
                commonHashes.retainAll(currentHashes);
                if (commonHashes.isEmpty())
                    return false;
            }
        }

        return commonHashes != null && !commonHashes.isEmpty();
    }
}
