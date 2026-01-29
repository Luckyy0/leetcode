package leetcode.P1792_MaximumAveragePassRatio;

import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int[] c : classes) {
            double p = c[0];
            double t = c[1];
            double gain = (p + 1) / (t + 1) - p / t;
            pq.offer(new double[] { gain, p, t });
        }

        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            double p = top[1] + 1;
            double t = top[2] + 1;
            double gain = (p + 1) / (t + 1) - p / t;
            pq.offer(new double[] { gain, p, t });
        }

        double sum = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            sum += top[1] / top[2];
        }

        return sum / classes.length;
    }
}
