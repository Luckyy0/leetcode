package leetcode.P1936_AddMinimumNumberOfRungs;

public class Solution {
    public int addRungs(int[] rungs, int dist) {
        int added = 0;
        int prev = 0;

        for (int r : rungs) {
            int gap = r - prev;
            if (gap > dist) {
                // Number of steps to bridge gap > dist.
                // We need intermediate rungs.
                // e.g. from 0 to 4 with dist 1. Need 1, 2, 3. rungs=3.
                // gap=4. (4-1)/1 = 3.
                added += (gap - 1) / dist;
            }
            prev = r;
        }

        return added;
    }
}
