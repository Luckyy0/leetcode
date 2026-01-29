package leetcode.P1851_MinimumIntervalToIncludeEachQuery;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int m = queries.length;

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Store queries with original index and sort
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[m];
        Arrays.fill(result, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0])); // size, end
        int intervalIdx = 0;

        for (int i = 0; i < m; i++) {
            int qVal = sortedQueries[i][0];
            int qIdx = sortedQueries[i][1];

            // Add intervals starting before/at qVal
            while (intervalIdx < n && intervals[intervalIdx][0] <= qVal) {
                int start = intervals[intervalIdx][0];
                int end = intervals[intervalIdx][1];
                int size = end - start + 1;
                pq.offer(new int[] { size, end });
                intervalIdx++;
            }

            // Remove intervals ending before qVal
            while (!pq.isEmpty() && pq.peek()[1] < qVal) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                result[qIdx] = pq.peek()[0];
            }
        }

        return result;
    }
}
