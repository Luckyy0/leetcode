package leetcode.P1981_MinimizeTheDifferenceBetweenTargetAndChosenElements;

public class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        // Max sum could be 70 * 70 = 4900.
        // We track reachable sums.
        boolean[] reachable = new boolean[4901];
        reachable[0] = true;

        int maxReachable = 0;

        for (int[] row : mat) {
            boolean[] next = new boolean[4901];
            int nextMax = 0;

            // Optimization: iterate only up to current maxReachable
            // Also no need to iterate row duplicates?
            boolean[] distinctRow = new boolean[71];
            for (int val : row)
                distinctRow[val] = true;

            for (int s = 0; s <= maxReachable; s++) {
                if (reachable[s]) {
                    for (int val = 1; val <= 70; val++) {
                        if (distinctRow[val]) {
                            if (s + val <= 4900) {
                                next[s + val] = true;
                                nextMax = Math.max(nextMax, s + val);
                            }
                        }
                    }
                }
            }
            reachable = next;
            maxReachable = nextMax;
        }

        int minDiff = Integer.MAX_VALUE;
        for (int s = 0; s <= 4900; s++) {
            if (reachable[s]) {
                minDiff = Math.min(minDiff, Math.abs(s - target));
                if (s > target && minDiff <= (s - target)) {
                    // Since s is increasing, if we passed target, diff is s - target.
                    // It will only increase further.
                    // But we might have found a better diff locally before.
                    // Optimization: break if (s - target) > minDiff? Yes.
                    if (s - target > minDiff)
                        break;
                }
            }
        }

        return minDiff;
    }
}
