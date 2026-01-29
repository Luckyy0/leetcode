package leetcode.P1786_NumberOfRestrictedPathsFromFirstToLastNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(new int[] { e[1], e[2] });
            adj[e[1]].add(new int[] { e[0], e[2] });
        }

        // Dijkstra from n
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { n, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u])
                continue;

            for (int[] next : adj[u]) {
                int v = next[0];
                int w = next[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] { v, dist[v] });
                }
            }
        }

        // DFS with memoization
        // Count paths from 1 to n such that dist decreases
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(1, n, adj, dist, memo);
    }

    // Returns ways from u to n
    private int dfs(int u, int target, List<int[]>[] adj, int[] dist, int[] memo) {
        if (u == target)
            return 1;
        if (memo[u] != -1)
            return memo[u];

        long ways = 0;
        for (int[] next : adj[u]) {
            int v = next[0];
            // Only move to v if dist[v] < dist[u] (closer to target)
            if (dist[v] < dist[u]) {
                ways = (ways + dfs(v, target, adj, dist, memo)) % MOD;
            }
        }

        return memo[u] = (int) ways;
    }
}
