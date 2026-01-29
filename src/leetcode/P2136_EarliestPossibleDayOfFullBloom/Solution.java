package leetcode.P2136_EarliestPossibleDayOfFullBloom;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++)
            indices[i] = i;

        // Sort by growTime descending
        Arrays.sort(indices, (a, b) -> Integer.compare(growTime[b], growTime[a]));

        int currentPlantEnd = 0;
        int maxBloom = 0;

        for (int i : indices) {
            currentPlantEnd += plantTime[i];
            maxBloom = Math.max(maxBloom, currentPlantEnd + growTime[i]);
        }

        return maxBloom;
    }
}
