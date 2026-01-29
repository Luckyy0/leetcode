package leetcode.P1434_NumberOfWaysToWearDifferentHatsToEachOther;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<List<Integer>> personWhoLikes = new ArrayList<>();
        for (int i = 0; i <= 40; i++)
            personWhoLikes.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int h : hats.get(i)) {
                personWhoLikes.get(h).add(i);
            }
        }

        int[] dp = new int[1 << n];
        dp[0] = 1;
        int MOD = 1_000_000_007;

        for (int h = 1; h <= 40; h++) {
            List<Integer> people = personWhoLikes.get(h);
            if (people.isEmpty())
                continue;

            // We need to update dp states using this hat.
            // Since we can use this hat for at most one person, or not use it.
            // Using a temporary array or iterating mask carefully is needed.
            // Iterating mask backwards to avoid using same hat multiple times in same step
            // logic doesn't work simply
            // because a single update affects other masks.
            // Copying is safer.

            int[] nextDp = dp.clone();

            for (int p : people) {
                // Try assigning hat h to person p
                for (int mask = 0; mask < (1 << n); mask++) {
                    // Check if person p is NOT already assigned in mask
                    // We look at state `mask` (where p is not assigned) and transition to `mask |
                    // (1<<p)`
                    if (((mask >> p) & 1) == 0) {
                        int nextMask = mask | (1 << p);
                        nextDp[nextMask] = (nextDp[nextMask] + dp[mask]) % MOD;
                    }
                }
            }
            dp = nextDp;
        }

        return dp[(1 << n) - 1];
    }
}
