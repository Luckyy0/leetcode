package leetcode.P802_FindEventualSafeStates;

import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] states = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, states)) {
                res.add(i);
            }
        }

        return res;
    }

    private boolean isSafe(int u, int[][] graph, int[] states) {
        if (states[u] != 0)
            return states[u] == 2;

        states[u] = 1; // Mark as visiting
        for (int v : graph[u]) {
            if (!isSafe(v, graph, states))
                return false;
        }

        states[u] = 2; // Verified safe
        return true;
    }
}
