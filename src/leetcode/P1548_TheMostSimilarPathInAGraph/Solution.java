package leetcode.P1548_TheMostSimilarPathInAGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> mostSimilarPath(int n, int[][] roads, String[] names, String[] targetPath) {
        int m = targetPath.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int[] r : roads) {
            adj[r[0]].add(r[1]);
            adj[r[1]].add(r[0]);
        }

        int[][] dp = new int[m][n];
        int[][] parent = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE / 2);

        for (int v = 0; v < n; v++) {
            dp[0][v] = names[v].equals(targetPath[0]) ? 0 : 1;
        }

        for (int i = 1; i < m; i++) {
            for (int u = 0; u < n; u++) {
                int cost = names[u].equals(targetPath[i]) ? 0 : 1;
                for (int v : adj[u]) {
                    if (dp[i - 1][v] + cost < dp[i][u]) {
                        dp[i][u] = dp[i - 1][v] + cost;
                        parent[i][u] = v;
                    }
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        int lastNode = -1;
        for (int v = 0; v < n; v++) {
            if (dp[m - 1][v] < minCost) {
                minCost = dp[m - 1][v];
                lastNode = v;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = m - 1; i >= 0; i--) {
            result.add(0, lastNode);
            lastNode = parent[i][lastNode];
        }

        return result;
    }
}
