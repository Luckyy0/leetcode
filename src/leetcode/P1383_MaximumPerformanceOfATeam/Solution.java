package leetcode.P1383_MaximumPerformanceOfATeam;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }

        // Sort by efficiency descending
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min heap for speeds
        long sumSpeed = 0;
        long maxPerf = 0;

        for (int[] eng : engineers) {
            int s = eng[0];
            int e = eng[1];

            pq.offer(s);
            sumSpeed += s;

            if (pq.size() > k) {
                sumSpeed -= pq.poll();
            }

            maxPerf = Math.max(maxPerf, sumSpeed * e);
        }

        return (int) (maxPerf % 1_000_000_007);
    }
}
