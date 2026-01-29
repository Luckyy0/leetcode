package leetcode.P871_MinimumNumberOfRefuelingStops;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int stops = 0;
        long currentDistance = startFuel;
        int i = 0, n = stations.length;

        while (currentDistance < target) {
            // Collect all stations reachable with current fuel
            while (i < n && stations[i][0] <= currentDistance) {
                pq.add(stations[i][1]);
                i++;
            }

            if (pq.isEmpty())
                return -1;

            // Refuel from the best station we've passed
            currentDistance += pq.poll();
            stops++;
        }

        return stops;
    }
}
