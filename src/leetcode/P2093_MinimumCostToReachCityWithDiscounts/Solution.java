package leetcode.P2093_MinimumCostToReachCityWithDiscounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] h : highways) {
            adj[h[0]].add(new int[] { h[1], h[2] });
            adj[h[1]].add(new int[] { h[0], h[2] });
        }

        int[][] dist = new int[n][discounts + 1];
        for (int[] r : dist)
            Arrays.fill(r, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        // {cost, u, usedDiscounts}
        pq.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int used = curr[2];

            if (cost > dist[u][used])
                continue;
            if (u == n - 1)
                return cost;

            for (int[] next : adj[u]) {
                int v = next[0];
                int weight = next[1];

                // Option 1: No discount
                if (cost + weight < dist[v][used]) {
                    dist[v][used] = cost + weight;
                    pq.offer(new int[] { cost + weight, v, used });
                }

                // Option 2: Use discount
                if (used < discounts) {
                    int newWeight = weight / 2;
                    if (cost + newWeight < dist[v][used + 1]) {
                        dist[v][used + 1] = cost + newWeight;
                        pq.offer(new int[] { cost + newWeight, v, used + 1 });
                    }
                }
            }
        }

        return -1;
    }
}
