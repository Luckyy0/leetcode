package leetcode.P2187_MinimumTimeToCompleteTrips;

public class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long minT = Integer.MAX_VALUE;
        for (int t : time)
            minT = Math.min(minT, t);

        long low = 1;
        long high = minT * totalTrips;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (check(time, totalTrips, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean check(int[] time, int totalTrips, long duration) {
        long trips = 0;
        for (int t : time) {
            trips += duration / t;
            if (trips >= totalTrips)
                return true;
        }
        return trips >= totalTrips;
    }
}
