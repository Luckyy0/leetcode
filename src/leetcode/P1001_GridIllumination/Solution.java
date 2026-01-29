package leetcode.P1001_GridIllumination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> row = new HashMap<>();
        Map<Integer, Integer> col = new HashMap<>();
        Map<Integer, Integer> d1 = new HashMap<>(); // r - c
        Map<Integer, Integer> d2 = new HashMap<>(); // r + c
        Set<Long> lampSet = new HashSet<>();

        for (int[] lamp : lamps) {
            int r = lamp[0];
            int c = lamp[1];
            long key = hash(r, c);
            if (lampSet.add(key)) {
                row.put(r, row.getOrDefault(r, 0) + 1);
                col.put(c, col.getOrDefault(c, 0) + 1);
                d1.put(r - c, d1.getOrDefault(r - c, 0) + 1);
                d2.put(r + c, d2.getOrDefault(r + c, 0) + 1);
            }
        }

        int[] res = new int[queries.length];
        int[][] dirs = {
                { 0, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
                { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
        };

        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];

            if (row.getOrDefault(r, 0) > 0 || col.getOrDefault(c, 0) > 0 ||
                    d1.getOrDefault(r - c, 0) > 0 || d2.getOrDefault(r + c, 0) > 0) {
                res[i] = 1;
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    long key = hash(nr, nc);
                    if (lampSet.remove(key)) {
                        row.put(nr, row.get(nr) - 1);
                        col.put(nc, col.get(nc) - 1);
                        d1.put(nr - nc, d1.get(nr - nc) - 1);
                        d2.put(nr + nc, d2.get(nr + nc) - 1);
                    }
                }
            }
        }

        return res;
    }

    // Simple hash function for coordinates, assuming n fits within standard limits
    // Since n is up to 10^9, we cannot use (r * n + c) directly if it overflows
    // long,
    // but Java long is 64-bit (max ~9 * 10^18), and max index is ~ 10^18, so it
    // fits.
    // However, coordinate hashing r << 32 | c is safer.
    private long hash(int r, int c) {
        return ((long) r << 32) | (long) c;
    }
}
