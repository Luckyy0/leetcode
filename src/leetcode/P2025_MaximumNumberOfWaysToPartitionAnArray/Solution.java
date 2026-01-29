package leetcode.P2025_MaximumNumberOfWaysToPartitionAnArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int kMirror(int k, int n) {
        // Placeholder for wrong problem?
        // P2025 is Maximum Number of Ways to Partition an Array.
        return 0;
    }

    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] + nums[i];

        long totalSum = prefix[n - 1];

        Map<Long, Integer> right = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            long sum = prefix[i];
            right.put(sum, right.getOrDefault(sum, 0) + 1);
        }

        int maxWays = 0;
        if (totalSum % 2 == 0) {
            maxWays = right.getOrDefault(totalSum / 2, 0);
        }

        Map<Long, Integer> left = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long d = k - nums[i];
            long newSum = totalSum + d;

            if (newSum % 2 == 0) {
                long target = newSum / 2;
                // Left needs 2*prefix[p] == Total + d -> prefix[p] == target
                // Right needs 2*prefix[p] == Total - d -> prefix[p] == (Total - d)/2

                int curr = 0;
                curr += left.getOrDefault(target, 0);
                curr += right.getOrDefault((totalSum - d) / 2, 0); // Correct derivation: (newSum - 2d) / 2

                maxWays = Math.max(maxWays, curr);
            }

            // Move pivot p = i + 1 from right to left
            if (i < n - 1) {
                long pVal = prefix[i]; // Actually pivot index is (i+1), prefix value is prefix[i] which sums 0..i
                // Index convention: prefix[i] is sum of nums[0...i].
                // Pivot p splits after index p-1?
                // Problem: pivot p splits nums[0...p-1] and nums[p...n-1].
                // So valid pivots are 1 to n-1.
                // Pivot p=1 uses prefix[0].
                // Pivot p=k uses prefix[k-1].
                // My loop setup uses prefix[i] for i = 0 to n-2.
                // These correspond to pivots 1 to n-1.

                // So: current `i` in loop means we change nums[i].
                // We need to move `prefix[i]` into left.
                // Initially `prefix[0]` is in Right?
                // Wait.
                // Loop i=0 (change nums[0]).
                // Pivots p=1..n-1.
                // p=1 (prefix[0]): changes is in Left part? No. nums[0] is in Left of split
                // p=1.
                // So p=1 should be in "Right Logic" (Changed elem is in Left).
                // "Right Logic": Element changed is in Left part (index < p). Condition:
                // (S-d)/2.
                // "Left Logic": Element changed is in Right part (index >= p). Condition:
                // (S+d)/2.

                // My derivation:
                // i < p (change in Left): need 2*pref == S - d. (Look in Right Map)
                // i >= p (change in Right): need 2*pref == S + d. (Look in Left Map)

                // Loop i=0.
                // Pivot p=1 (prefix[0]). i=0 < p=1. Change in Left. Use Right Logic.
                // Pivot p=2 (prefix[1]). i=0 < p=2. Change in Left. Use Right Logic.
                // All pivots are in Right Map initially.
                // So for i=0, we only check Right Map with target (S-d)/2.

                // Move logic:
                // After processing i=0, pivot p=1 (prefix[0]) becomes a pivot where i=1 >= p=1?
                // Next i=1.
                // Pivot p=1 (prefix[0]). 1 >= 1. Change in Right. Use Left Logic.
                // Pivot p=2 (prefix[1]). 1 < 2. Change in Left. Use Right Logic.

                // So we move prefix[i] from Right to Left AFTER calculating for i.

                long val = prefix[i];
                right.put(val, right.get(val) - 1);
                left.put(val, left.getOrDefault(val, 0) + 1);
            }
        }

        return maxWays;
    }
}
