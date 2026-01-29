package leetcode.P2107_NumberOfUniqueFlavorsAfterSharingKCandies;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int shareCandies(int[] candies, int k) {
        // Assume maximum flavor value is manageable or use Map
        // Using Map for safety
        Map<Integer, Integer> freq = new HashMap<>();
        for (int c : candies)
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        if (k == 0)
            return freq.size();

        // Remove first k (0 to k-1)
        for (int i = 0; i < k; i++) {
            int c = candies[i];
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) == 0)
                freq.remove(c);
        }

        int maxUnique = freq.size();

        // Slide
        int n = candies.length;
        for (int i = 1; i <= n - k; i++) {
            // Restore candies[i-1]
            int added = candies[i - 1];
            freq.put(added, freq.getOrDefault(added, 0) + 1);

            // Remove candies[i+k-1]
            int removed = candies[i + k - 1];
            freq.put(removed, freq.get(removed) - 1);
            if (freq.get(removed) == 0)
                freq.remove(removed);

            maxUnique = Math.max(maxUnique, freq.size());
        }

        return maxUnique;
    }
}
