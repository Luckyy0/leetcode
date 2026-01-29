package leetcode.P685_RedundantConnectionII;

class Solution {
    class DSU {
        int[] parent;

        public DSU(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }

        public int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        public boolean union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                return true;
            }
            return false;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] edge1 = null, edge2 = null, lastEdge = null;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parent[v] != 0) {
                // Node v has two parents
                edge1 = new int[] { parent[v], v };
                edge2 = new int[] { u, v };
            } else {
                parent[v] = u;
            }
        }

        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            if (edge == edge2)
                continue; // Skip edge2 temporarily
            if (!dsu.union(edge[0], edge[1])) {
                lastEdge = edge;
            }
        }

        // Cases logic
        if (edge1 != null) {
            if (lastEdge != null)
                return edge1; // Removing edge2 didn't fix the cycle detected earlier
            return edge2; // Removing edge2 fixed the structure
        }
        return lastEdge; // No two-parents case, standard cycle
    }
}
