package leetcode.P1840_MaximumBuildingHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] { 1, 0 });
        for (int[] r : restrictions) {
            list.add(r);
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        // Pass 1: L -> R
        for (int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            int[] prev = list.get(i - 1);
            int dist = curr[0] - prev[0];
            curr[1] = Math.min(curr[1], prev[1] + dist);
        }

        // Pass 2: R -> L
        for (int i = list.size() - 2; i >= 0; i--) {
            int[] curr = list.get(i);
            int[] next = list.get(i + 1);
            int dist = next[0] - curr[0];
            curr[1] = Math.min(curr[1], next[1] + dist);
        }

        int maxHeight = 0;

        // Check intervals between restrictions
        for (int i = 0; i < list.size() - 1; i++) {
            int[] curr = list.get(i);
            int[] next = list.get(i + 1);
            int h1 = curr[1];
            int h2 = next[1];
            int dist = next[0] - curr[0];

            // Peak formula: (h1 + h2 + dist) / 2
            int peak = (h1 + h2 + dist) / 2;
            maxHeight = Math.max(maxHeight, peak);
        }

        // Check final segment from last restriction to n
        // Since no restrictions after, height just increases by 1 until n
        // If list empty (only 1,0), loops didn't run.
        if (!list.isEmpty()) {
            int[] last = list.get(list.size() - 1);
            int h = last[1];
            int dist = n - last[0];
            maxHeight = Math.max(maxHeight, h + dist);
        }

        return maxHeight;
    }
}
