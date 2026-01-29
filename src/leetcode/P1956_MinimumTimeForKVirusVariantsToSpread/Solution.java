package leetcode.P1956_MinimumTimeForKVirusVariantsToSpread;

public class Solution {
    public int minDayskVariants(int[][] points, int k) {
        int minX = 101, maxX = 0;
        int minY = 101, maxY = 0;

        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
        }

        int low = 0, high = 200; // Sufficient range
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(points, k, mid, minX, maxX, minY, maxY)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Check if there exists a point (x, y) covered by k sources with radius t
    private boolean check(int[][] points, int k, int t, int minX, int maxX, int minY, int maxY) {
        // Optimization: iterate range [minX, maxX] and [minY, maxY].
        // The optimal meeting point is within the bounding box of the sources.
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                int count = 0;
                for (int[] p : points) {
                    if (Math.abs(x - p[0]) + Math.abs(y - p[1]) <= t) {
                        count++;
                    }
                }
                if (count >= k)
                    return true;
            }
        }
        return false;
    }
}
