package leetcode.P1057_CampusBikes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    class Pair {
        int w, b, dist;

        Pair(int w, int b, int dist) {
            this.w = w;
            this.b = b;
            this.dist = dist;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        int m = bikes.length;
        // Use bucket sort since max dist is small (< 2000)
        List<Pair>[] buckets = new ArrayList[2001];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int dist = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                if (buckets[dist] == null)
                    buckets[dist] = new ArrayList<>();
                buckets[dist].add(new Pair(i, j, dist));
            }
        }

        int[] res = new int[n];
        java.util.Arrays.fill(res, -1);
        boolean[] bikeUsed = new boolean[m];
        int assignedCount = 0;

        for (int d = 0; d <= 2000; d++) {
            if (buckets[d] == null)
                continue;
            // Pairs are added in order of worker (i loop) then bike (j loop).
            // Wait, i is loop 0..n, j is loop 0..m.
            // So implicit order is worker asc, then bike asc.
            // Is this guaranteed?
            // - Within same distance bucket, we add (0,0), (0,1)... (1,0)...
            // So worker is asc. Matches rule 2.
            // Bikes are asc for same worker. Matches rule 3?
            // Yes.

            for (Pair p : buckets[d]) {
                if (res[p.w] == -1 && !bikeUsed[p.b]) {
                    res[p.w] = p.b;
                    bikeUsed[p.b] = true;
                    assignedCount++;
                    if (assignedCount == n)
                        return res;
                }
            }
        }

        return res;
    }
}
