package leetcode.P857_MinimumCostToHireKWorkers;

import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = (double) quality[i];
        }

        // Sort by ratio
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double sumQuality = 0;
        double minCost = Double.MAX_VALUE;

        for (double[] worker : workers) {
            double ratio = worker[0];
            sumQuality += worker[1];
            maxHeap.add(worker[1]);

            if (maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }

            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, sumQuality * ratio);
            }
        }

        return minCost;
    }
}
