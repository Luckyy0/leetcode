package leetcode.P1921_EliminateMaximumNumberOfMonsters;

import java.util.Arrays;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] arrivalTimes = new double[n];

        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (double) dist[i] / speed[i];
        }

        Arrays.sort(arrivalTimes);

        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }

        return n;
    }
}
