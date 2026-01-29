package leetcode.P956_TallestBillboard;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int tallestBillboard(int[] rods) {
        // dp[diff] = max height of shorter rod with that diff
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for (int r : rods) {
            Map<Integer, Integer> next = new HashMap<>(dp);
            for (int diff : dp.keySet()) {
                int h = dp.get(diff);
                // 1. Add to taller side
                next.put(diff + r, Math.max(next.getOrDefault(diff + r, 0), h));
                // 2. Add to shorter side
                int newDiff = Math.abs(diff - r);
                int newH = h + Math.min(diff, r);
                next.put(newDiff, Math.max(next.getOrDefault(newDiff, 0), newH));
            }
            dp = next;
        }

        return dp.get(0);
    }
}
