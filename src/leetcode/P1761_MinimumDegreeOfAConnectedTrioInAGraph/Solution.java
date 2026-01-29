package leetcode.P1761_MinimumDegreeOfAConnectedTrioInAGraph;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean[][] adj = new boolean[n + 1][n + 1];
        int[] degree = new int[n + 1];

        for (int[] edge : edges) {
            adj[edge[0]][edge[1]] = true;
            adj[edge[1]][edge[0]] = true;
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int minDeg = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (adj[i][j]) {
                    for (int k = j + 1; k <= n; k++) {
                        if (adj[i][k] && adj[j][k]) {
                            found = true;
                            int currentDeg = degree[i] + degree[j] + degree[k] - 6;
                            minDeg = Math.min(minDeg, currentDeg);
                        }
                    }
                }
            }
        }

        return found ? minDeg : -1;
    }
}
