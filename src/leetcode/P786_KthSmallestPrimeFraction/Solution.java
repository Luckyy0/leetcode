package leetcode.P786_KthSmallestPrimeFraction;

import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        // PriorityQueue stores [numeratorIndex, denominatorIndex]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare((double) arr[a[0]] / arr[a[1]], (double) arr[b[0]] / arr[b[1]]));

        // Push the smallest fraction for each denominator
        for (int j = 1; j < n; j++) {
            pq.add(new int[] { 0, j });
        }

        while (--k > 0) {
            int[] top = pq.poll();
            int i = top[0];
            int j = top[1];
            if (i + 1 < j) {
                pq.add(new int[] { i + 1, j });
            }
        }

        int[] res = pq.poll();
        return new int[] { arr[res[0]], arr[res[1]] };
    }
}
