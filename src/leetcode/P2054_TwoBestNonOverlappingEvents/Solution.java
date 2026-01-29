package leetcode.P2054_TwoBestNonOverlappingEvents;

import java.util.Arrays;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int n = events.length;
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(events[i][2], suffixMax[i + 1]);
        }

        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            // Option 1: Just pick this event (and possibly none else if this is best
            // single)
            // But we actually iterate all events. So considering "event i + best valid
            // second" covers all pairs.
            // Also need to cover single event case? Max of all values.
            maxVal = Math.max(maxVal, events[i][2]);

            // Find second event j such that start[j] > end[i]
            int targetStart = events[i][1] + 1;
            int idx = binarySearch(events, targetStart);

            if (idx < n) {
                maxVal = Math.max(maxVal, events[i][2] + suffixMax[idx]);
            }
        }

        return maxVal;
    }

    private int binarySearch(int[][] events, int targetStart) {
        int l = 0, r = events.length - 1;
        int res = events.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (events[mid][0] >= targetStart) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
