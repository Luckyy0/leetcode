package leetcode.P1815_MaximumNumberOfGroupsGettingFreshDonuts;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Long, Integer> memo;
    private int batchSize;

    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        int[] counts = new int[batchSize];
        int ans = 0;

        for (int g : groups) {
            int rem = g % batchSize;
            if (rem == 0) {
                ans++;
            } else if (counts[batchSize - rem] > 0) {
                // Greedy match
                counts[batchSize - rem]--;
                ans++;
            } else {
                counts[rem]++;
            }
        }

        this.memo = new HashMap<>();
        ans += dfs(0, counts); // Start with remainder 0

        return ans;
    }

    private int dfs(int currentRem, int[] counts) {
        long key = encode(counts) * batchSize + currentRem; // Include currentRem in key if needed, or derived?
        // Wait, currentRem depends on what we picked.
        // Actually, if we encode 'counts' and 'currentRem', it's unique.

        if (memo.containsKey(key))
            return memo.get(key);

        int max = 0;
        int remainingGroups = 0;

        for (int i = 1; i < batchSize; i++) {
            if (counts[i] > 0) {
                remainingGroups++;
                counts[i]--;
                // If currentRem is 0, we get +1 score.
                // New rem is (currentRem + i) % batchSize.
                int gain = (currentRem == 0 ? 1 : 0);
                max = Math.max(max, gain + dfs((currentRem + i) % batchSize, counts));
                counts[i]++;
            }
        }

        if (remainingGroups == 0)
            return 0;

        memo.put(key, max);
        return max;
    }

    // Encode counts array into a long
    // Counts are small <= 30 (5 bits).
    // batchSize <= 9. Array size <= 8.
    // 8 * 5 = 40 bits. Fits in long.
    private long encode(int[] counts) {
        long res = 0;
        for (int i = 1; i < batchSize; i++) {
            res = (res << 5) | counts[i];
        }
        return res;
    }
}
