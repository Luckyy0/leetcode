package leetcode.P1377_FrogPositionAfterTSeconds;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (n == 1)
            return 1.0;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n + 1];
        return dfs(1, t, target, adj, visited);
    }

    private double dfs(int u, int t, int target, List<List<Integer>> adj, boolean[] visited) {
        visited[u] = true;

        // Count unvisited neighbors (children)
        int childrenCount = 0;
        for (int v : adj.get(u)) {
            if (!visited[v])
                childrenCount++;
        }

        if (u == target) {
            // Reached target
            // If time is exactly up, OR we have time left but minimal moves (cannot move
            // further)
            if (t == 0 || childrenCount == 0)
                return 1.0;
            return 0.0;
        }

        if (t == 0)
            return 0.0; // Time up, not at target

        if (childrenCount > 0) {
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    double res = dfs(v, t - 1, target, adj, visited);
                    if (res > 0) {
                        return res / childrenCount;
                    }
                }
            }
        }

        return 0.0;
    }
}
