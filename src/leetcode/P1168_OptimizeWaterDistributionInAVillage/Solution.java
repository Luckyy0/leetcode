package leetcode.P1168_OptimizeWaterDistributionInAVillage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    int[] parent;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // Build edge list
        List<int[]> edges = new ArrayList<>();

        // Virtual edges from node 0 (source)
        for (int i = 0; i < n; i++) {
            edges.add(new int[] { 0, i + 1, wells[i] });
        }

        // Pipe edges
        for (int[] p : pipes) {
            edges.add(p);
        }

        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        int cost = 0;
        int connected = 0; // Edges added. Need n edges to connect n+1 nodes in MST.
        // Or simply iterate all edges.

        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                cost += e[2];
                connected++;
                if (connected == n)
                    break; // Optimization
            }
        }

        return cost;
    }

    private int find(int i) {
        if (parent[i] == i)
            return i;
        parent[i] = find(parent[i]);
        return parent[i];
    }

    private boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            return true;
        }
        return false;
    }
}
