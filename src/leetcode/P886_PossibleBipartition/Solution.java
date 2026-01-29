package leetcode.P886_PossibleBipartition;

import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }

        int[] colors = new int[n + 1]; // 0: none, 1: group1, -1: group2
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, 1, colors, adj))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs(int u, int c, int[] colors, List<List<Integer>> adj) {
        colors[u] = c;
        for (int v : adj.get(u)) {
            if (colors[v] == c)
                return false;
            if (colors[v] == 0) {
                if (!dfs(v, -c, colors, adj))
                    return false;
            }
        }
        return true;
    }
}
