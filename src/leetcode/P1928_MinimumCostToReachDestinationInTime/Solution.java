package leetcode.P1928_MinimumCostToReachDestinationInTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(new int[] { e[1], e[2] });
            adj[e[1]].add(new int[] { e[0], e[2] });
        }

        // {cost, time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { passingFees[0], 0, 0 });

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int time = curr[1];
            int u = curr[2];

            if (u == n - 1)
                return cost;

            // Pruning: if current time > previously found faster path with smaller/equal
            // cost, ignore
            // Since we poll by cost asc, previous popped states had cost <= current.
            // If they also had time <= current, then current is useless.
            // minTime[u] tracks the best time seen so far (which effectively corresponds to
            // "seen with lower cost").
            // Wait, minTime logic:
            // If we extract (C, T, u). If T >= minTime[u], ignore.
            // Because previous visit (C', T', u) had C' <= C and T' <= T.
            if (time > minTime[u])
                continue;
            // Actually, we might have updated minTime when pushing, but usually check after
            // pop.
            // However, typical dijkstra checks dist[u]. Here "dist" is multidimensional
            // pareto frontier.
            // Simplified: minTime[u] stores the smallest time reached for 'u' among all
            // paths processed so far (which have <= cost).

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];
                int newTime = time + weight;
                int newCost = cost + passingFees[v];

                if (newTime <= maxTime) {
                    if (newTime < minTime[v]) {
                        minTime[v] = newTime;
                        pq.offer(new int[] { newCost, newTime, v });
                    }
                }
            }
        }

        return -1;
    }
}
