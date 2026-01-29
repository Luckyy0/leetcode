package leetcode.P1591_StrangePrinterII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean isPrintable(int[][] targetGrid) {
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        int maxColor = 60;

        // Bounding boxes
        int[] minR = new int[maxColor + 1];
        int[] maxR = new int[maxColor + 1];
        int[] minC = new int[maxColor + 1];
        int[] maxC = new int[maxColor + 1];

        Arrays.fill(minR, Integer.MAX_VALUE);
        Arrays.fill(maxR, Integer.MIN_VALUE);
        Arrays.fill(minC, Integer.MAX_VALUE);
        Arrays.fill(maxC, Integer.MIN_VALUE);

        boolean[] present = new boolean[maxColor + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c = targetGrid[i][j];
                present[c] = true;
                minR[c] = Math.min(minR[c], i);
                maxR[c] = Math.max(maxR[c], i);
                minC[c] = Math.min(minC[c], j);
                maxC[c] = Math.max(maxC[c], j);
            }
        }

        // Build Graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= maxColor; i++)
            adj.add(new ArrayList<>());

        for (int c = 1; c <= maxColor; c++) {
            if (!present[c])
                continue;

            for (int i = minR[c]; i <= maxR[c]; i++) {
                for (int j = minC[c]; j <= maxC[c]; j++) {
                    int other = targetGrid[i][j];
                    if (other != c) {
                        // C must be printed before Other
                        // Edge C -> Other
                        adj.get(c).add(other);
                    }
                }
            }
        }

        // Detect Cycle using DFS states: 0=unvisited, 1=visiting, 2=visited
        int[] state = new int[maxColor + 1];
        for (int c = 1; c <= maxColor; c++) {
            if (present[c] && state[c] == 0) {
                if (hasCycle(c, adj, state))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int u, List<List<Integer>> adj, int[] state) {
        state[u] = 1; // Visiting
        for (int v : adj.get(u)) {
            if (state[v] == 1)
                return true; // Cycle
            if (state[v] == 0) {
                if (hasCycle(v, adj, state))
                    return true;
            }
        }
        state[u] = 2; // Visited
        return false;
    }
}
