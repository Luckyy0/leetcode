package leetcode.P2065_MaximumPathQualityOfAGraph;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int maxQuality = 0;
    int[] values;
    int maxTime;
    List<int[]>[] adj;
    int[] visited;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.values = values;
        this.maxTime = maxTime;
        int n = values.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(new int[] { e[1], e[2] });
            adj[e[1]].add(new int[] { e[0], e[2] });
        }

        visited = new int[n];
        visited[0]++;
        dfs(0, 0, values[0]);

        return maxQuality;
    }

    private void dfs(int u, int timeUsed, int currentVal) {
        if (u == 0) {
            maxQuality = Math.max(maxQuality, currentVal);
        }

        for (int[] next : adj[u]) {
            int v = next[0];
            int t = next[1];

            if (timeUsed + t <= maxTime) {
                visited[v]++;
                int addVal = (visited[v] == 1) ? values[v] : 0;

                dfs(v, timeUsed + t, currentVal + addVal);

                visited[v]--;
            }
        }
    }
}
