package leetcode.P1787_MakeTheXOROfAllSegmentsEqualToZero;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minChanges(int[] nums, int k) {
        int n = nums.length;
        int LIMIT = 1024;

        // Count frequencies at each index mod k
        Map<Integer, Integer>[] counts = new HashMap[k];
        int[] size = new int[k];

        for (int i = 0; i < k; i++)
            counts[i] = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int idx = i % k;
            counts[idx].put(nums[i], counts[idx].getOrDefault(nums[i], 0) + 1);
            size[idx]++;
        }

        // dp[mask]: min changes to get xor sum 'mask' using first i groups
        int[] dp = new int[LIMIT];
        Arrays.fill(dp, Integer.MAX_VALUE / 2); // Avoid overflow
        dp[0] = 0;

        for (int i = 0; i < k; i++) {
            int[] nextDp = new int[LIMIT];
            Arrays.fill(nextDp, Integer.MAX_VALUE / 2);

            // Calculate min cost from previous state
            int minPrev = Integer.MAX_VALUE / 2;
            for (int val : dp)
                minPrev = Math.min(minPrev, val);

            // Case 1: Change current position to a value NOT present in the column
            // Cost is size[i] (change all) + minPrev
            Arrays.fill(nextDp, minPrev + size[i]);

            // Case 2: Change current position to value 'v' present in the column
            // We iterate all possible previous XORs? No, iterate v in counts[i].
            // For each 'v' in counts[i], we can transition from dp[mask ^ v]
            // changes = dp[mask ^ v] + size[i] - count[v]

            for (Map.Entry<Integer, Integer> entry : counts[i].entrySet()) {
                int v = entry.getKey();
                int count = entry.getValue();

                for (int mask = 0; mask < LIMIT; mask++) {
                    // prevXor ^ v = mask => prevXor = mask ^ v
                    nextDp[mask] = Math.min(nextDp[mask], dp[mask ^ v] + size[i] - count);
                }
            }

            dp = nextDp;
        }

        return dp[0];
    }
}
