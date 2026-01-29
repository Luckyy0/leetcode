package leetcode.P1192_CriticalConnectionsInANetwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> adj;
    int[] disc;
    int[] low;
    int time = 0;
    List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> c : connections) {
            adj.get(c.get(0)).add(c.get(1));
            adj.get(c.get(1)).add(c.get(0));
        }

        disc = new int[n];
        low = new int[n];
        Arrays.fill(disc, -1); // Unvisited
        bridges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                dfs(i, -1);
            }
        }

        return bridges;
    }

    private void dfs(int u, int p) {
        disc[u] = low[u] = ++time;

        for (int v : adj.get(u)) {
            if (v == p)
                continue; // Don't go back to parent immediately

            if (disc[v] != -1) {
                // Back-edge
                low[u] = Math.min(low[u], disc[v]);
            } else {
                // Tree-edge
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            }
        }
    }
}
