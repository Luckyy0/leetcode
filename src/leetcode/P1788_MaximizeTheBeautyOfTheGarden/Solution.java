package leetcode.P1788_MaximizeTheBeautyOfTheGarden;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maximumBeauty(int[] flowers) {
        int n = flowers.length;
        int[] prefixPos = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixPos[i + 1] = prefixPos[i] + Math.max(0, flowers[i]);
        }

        Map<Integer, Integer> maxPrevTerm = new HashMap<>(); // Stores max(flowers[i] - MP[i+1])
        int maxBeauty = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            int val = flowers[j];
            int currentMP = prefixPos[j]; // Sum of positives before j

            // Try to match with previous i
            if (maxPrevTerm.containsKey(val)) {
                // Term: flowers[j] + MP[j] + (flowers[i] - MP[i+1])
                int beauty = val + currentMP + maxPrevTerm.get(val);
                maxBeauty = Math.max(maxBeauty, beauty);
            }

            // Update map for future j
            // We want to maximize (flowers[i] - MP[i+1])
            // Current i is j. MP[i+1] is prefixPos[j+1]
            int term = val - prefixPos[j + 1];
            if (!maxPrevTerm.containsKey(val) || term > maxPrevTerm.get(val)) {
                maxPrevTerm.put(val, term);
            }
        }

        return maxBeauty;
    }
}
