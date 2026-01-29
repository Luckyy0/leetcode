package leetcode.P1681_MinimumIncompatibility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int size = n / k;

        // Count frequencies to fail early
        int[] counts = new int[17];
        for (int num : nums) {
            counts[num]++;
            if (counts[num] > k)
                return -1;
        }

        // Use a map to store valid subsets grouped by their lowest set bit
        // Key: lowest bit index. Value: List of masks
        Map<Integer, List<Integer>> subsetsByLowBit = new HashMap<>();
        for (int i = 0; i < n; i++)
            subsetsByLowBit.put(i, new ArrayList<>());

        int[] subsetValue = new int[1 << n];
        Arrays.fill(subsetValue, -1);

        // Iterate all submasks of size 'size'
        // Since N=16, iterating 2^16 is fine to find valid ones
        for (int mask = 1; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) == size) {
                // Validate no duplicates and compute range
                int currentMask = mask;
                int minVal = 17, maxVal = 0;
                boolean duplicate = false;
                int seen = 0; // tracking actual values seen in this subset

                int lowestBit = -1;

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        if (lowestBit == -1)
                            lowestBit = i;
                        int val = nums[i];
                        if ((seen & (1 << val)) != 0) {
                            duplicate = true;
                            break;
                        }
                        seen |= (1 << val);
                        minVal = Math.min(minVal, val);
                        maxVal = Math.max(maxVal, val);
                    }
                }

                if (!duplicate) {
                    subsetValue[mask] = maxVal - minVal;
                    subsetsByLowBit.get(lowestBit).add(mask);
                }
            }
        }

        // DP
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE / 2)
                continue;

            // Only process if mask represents full subsets so far
            if (Integer.bitCount(mask) % size != 0)
                continue;

            // Should be reached by logic anyway

            // Find lowest unset bit
            int lowestUnset = -1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    lowestUnset = i;
                    break;
                }
            }

            if (lowestUnset == -1)
                continue; // All set

            // Try all valid subsets starting with lowestUnset
            List<Integer> candidates = subsetsByLowBit.get(lowestUnset);
            if (candidates != null) {
                for (int sub : candidates) {
                    // Check strict disjoint
                    if ((mask & sub) == 0) {
                        dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + subsetValue[sub]);
                    }
                }
            }
        }

        int res = dp[(1 << n) - 1];
        return res >= Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
