package leetcode.P1655_DistributeRepeatingIntegers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer> freq = new ArrayList<>(counts.values());
        int m = quantity.length;
        int maxMask = 1 << m;

        int[] sums = new int[maxMask];
        for (int mask = 0; mask < maxMask; mask++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += quantity[i];
                }
            }
            sums[mask] = sum;
        }

        // dp[mask] = true if mask can be satisfied by previous counts
        boolean[] dp = new boolean[maxMask];
        dp[0] = true;

        for (int f : freq) {
            // Traverse masks in reverse to avoid using same freq multiple times for same
            // mask update
            // Wait, we need to iterate all reachable masks and try to extend them.
            // Better: use a temp array or careful loop.
            // Since we want to update dp[mask] using dp[prev_mask] + current_f covering
            // (mask ^ prev_mask)

            boolean[] nextDp = dp.clone();

            for (int mask = maxMask - 1; mask >= 0; mask--) {
                if (dp[mask]) {
                    // Try to satisfy remaining submasks using current freq 'f'
                    int remaining = (maxMask - 1) ^ mask;

                    // Iterate submasks of 'remaining'
                    for (int sub = remaining; sub > 0; sub = (sub - 1) & remaining) {
                        if (sums[sub] <= f) {
                            nextDp[mask | sub] = true;
                        }
                    }
                }
            }
            dp = nextDp;
            if (dp[maxMask - 1])
                return true;
        }

        return dp[maxMask - 1];
    }
}
