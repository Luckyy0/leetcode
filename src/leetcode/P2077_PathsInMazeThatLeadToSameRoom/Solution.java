package leetcode.P2077_PathsInMazeThatLeadToSameRoom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public int numberOfPaths(int n, int[][] corridors) {
        // Build adjacency graph
        // Optimize: Use HashSet for quick lookup? Or boolean matrix
        // Given N <= 1000? If N=1000, boolean matrix is 1MB. Efficient.

        boolean[][] connected = new boolean[n + 1][n + 1];
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] c : corridors) {
            int u = c[0];
            int v = c[1];
            connected[u][v] = true;
            connected[v][u] = true;
            // Store directed edges for u < v to avoid duplicates naturally?
            // Yes, store only bigger neighbors to iterate u < v < w.
            if (u < v)
                adj[u].add(v);
            else
                adj[v].add(u);
        }

        int count = 0;

        for (int u = 1; u <= n; u++) {
            for (int v : adj[u]) {
                // v > u
                for (int w : adj[v]) {
                    // w > v
                    if (connected[u][w]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
