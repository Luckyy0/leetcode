package leetcode.P1976_NumberOfWaysToArriveAtDestination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] r : roads) {
            adj[r[0]].add(new int[] { r[1], r[2] });
            adj[r[1]].add(new int[] { r[0], r[2] });
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] count = new long[n];
        count[0] = 1;

        // {dist, u}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u])
                continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];
                long newDist = d + weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    count[v] = count[u];
                    pq.offer(new long[] { newDist, v });
                } else if (newDist == dist[v]) {
                    count[v] = (count[v] + count[u]) % MOD;
                }
            }
        }

        return (int) count[n - 1];
    }
}
