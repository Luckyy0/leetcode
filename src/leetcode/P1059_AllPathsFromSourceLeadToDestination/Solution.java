package leetcode.P1059_AllPathsFromSourceLeadToDestination;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : edges)
            graph.get(e[0]).add(e[1]);

        // 0: unvisited, 1: visiting, 2: visited
        int[] state = new int[n];
        return dfs(graph, source, destination, state);
    }

    private boolean dfs(List<List<Integer>> graph, int node, int dest, int[] state) {
        if (state[node] == 1)
            return false; // Cycle
        if (state[node] == 2)
            return true; // Already verified

        if (graph.get(node).isEmpty()) {
            return node == dest;
        }

        state[node] = 1;
        for (int next : graph.get(node)) {
            if (!dfs(graph, next, dest, state))
                return false;
        }
        state[node] = 2;
        return true;
    }
}
