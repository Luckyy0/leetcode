package leetcode.P1326_MinimumNumberOfTapsToOpenToWaterAGarden;

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (ranges[i] == 0)
                continue;
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }

        int taps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, maxReach[i]);

            if (i == currentEnd) {
                if (farthest <= i)
                    return -1; // Cannot extend
                currentEnd = farthest;
                taps++;
            }
        }

        return (currentEnd < n) ? -1 : taps;
    }
}
