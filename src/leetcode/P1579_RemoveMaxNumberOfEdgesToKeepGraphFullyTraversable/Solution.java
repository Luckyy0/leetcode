package leetcode.P1579_RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable;

import java.util.Arrays;

public class Solution {
    class DSU {
        int[] parent;
        int components;

        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
                parent[i] = i;
            components = n;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                components--;
                return true;
            }
            return false;
        }

        public boolean isConnected() {
            return components == 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        // Sort edges to process Type 3 first
        // Type 3 = 3, Type 2 = 2, Type 1 = 1. Descending order of type works.
        Arrays.sort(edges, (a, b) -> b[0] - a[0]);

        DSU dsuAlice = new DSU(n);
        DSU dsuBob = new DSU(n);
        int edgesUsed = 0;

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1];
            int v = edge[2];

            if (type == 3) {
                // Type 3: Add to both
                // If it helps connect in Alice, it definitely helps in Bob initially (since
                // they start same)
                boolean unionAlice = dsuAlice.union(u, v);
                boolean unionBob = dsuBob.union(u, v);

                // If it merged components in either graph, it's useful.
                // Since they start identical, unionAlice == unionBob.
                if (unionAlice) {
                    edgesUsed++;
                }
            } else if (type == 1) {
                // Alice only
                if (dsuAlice.union(u, v)) {
                    edgesUsed++;
                }
            } else if (type == 2) {
                // Bob only
                if (dsuBob.union(u, v)) {
                    edgesUsed++;
                }
            }
        }

        if (dsuAlice.isConnected() && dsuBob.isConnected()) {
            return edges.length - edgesUsed;
        }
        return -1;
    }
}
