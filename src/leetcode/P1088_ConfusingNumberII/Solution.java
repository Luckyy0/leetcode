package leetcode.P1088_ConfusingNumberII;

import java.util.Map;
import java.util.HashMap;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;

    public int confusingNumberII(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0, n);
        return count;
    }

    private void dfs(long curr, int limit) {
        if (isConfusing(curr)) {
            count++;
        }

        for (int d : new int[] { 0, 1, 6, 8, 9 }) {
            if (curr == 0 && d == 0)
                continue; // Skip leading zeros

            long next = curr * 10 + d;
            if (next <= limit) {
                dfs(next, limit);
            }
        }
    }

    private boolean isConfusing(long n) {
        long original = n;
        long rotated = 0;

        while (n > 0) {
            int d = (int) (n % 10);
            rotated = rotated * 10 + map.get(d);
            n /= 10;
        }

        // n became 0. Compare
        return rotated != original;
    }
}
