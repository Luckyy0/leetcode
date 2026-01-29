package leetcode.P1617_CountSubtreesWithMaxDistanceBetweenCities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        for (int i = 0; i < n; i++)
            dist[i][i] = 0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            dist[u][v] = dist[v][u] = 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int[] result = new int[n - 1];

        // Iterate subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            int nodesCount = Integer.bitCount(mask);
            if (nodesCount < 2)
                continue;

            // Check connectivity
            // Find a start node
            int startNode = -1;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    startNode = i;
                    break;
                }
            }

            if (startNode == -1)
                continue;

            // BFS for connectivity
            int visitedCount = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(startNode);
            int visitedMask = (1 << startNode);
            visitedCount++;

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if ((mask & (1 << v)) != 0 && (visitedMask & (1 << v)) == 0) {
                        visitedMask |= (1 << v);
                        visitedCount++;
                        q.offer(v);
                    }
                }
            }

            if (visitedCount != nodesCount)
                continue; // Not connected

            // Calculate Diameter
            int maxDist = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = i + 1; j < n; j++) {
                        if ((mask & (1 << j)) != 0) {
                            maxDist = Math.max(maxDist, dist[i][j]);
                        }
                    }
                }
            }

            if (maxDist > 0 && maxDist < n) {
                result[maxDist - 1]++;
            }
        }

        return result;
    }
}
