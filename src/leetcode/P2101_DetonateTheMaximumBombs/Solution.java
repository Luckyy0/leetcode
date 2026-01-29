package leetcode.P2101_DetonateTheMaximumBombs;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                long dx = bombs[i][0] - bombs[j][0];
                long dy = bombs[i][1] - bombs[j][1];
                long r2 = (long) bombs[i][2] * bombs[i][2];
                if (dx * dx + dy * dy <= r2) {
                    adj[i].add(j);
                }
            }
        }

        int maxDetonated = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            maxDetonated = Math.max(maxDetonated, dfs(i, adj, visited));
        }
        return maxDetonated;
    }

    private int dfs(int u, List<Integer>[] adj, boolean[] visited) {
        visited[u] = true;
        int count = 1;
        for (int v : adj[u]) {
            if (!visited[v]) {
                count += dfs(v, adj, visited);
            }
        }
        return count;
    }
}
