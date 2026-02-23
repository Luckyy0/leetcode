package leet_code.Problem_684_Medium_Redundant_Connection;

public class Solution {

    /**
     * Finds the redundant edge in an undirected graph that forms a cycle.
     * Strategy: Use Disjoint Set Union (DSU) for cycle detection.
     * Time: O(N * alpha(N)), Space: O(N).
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Initialize DSU: each node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            // If nodes share the same root, they are already connected
            // Adding this edge forms a cycle
            if (rootU == rootV) {
                return edge;
            }

            // Union: merge the sets
            parent[rootU] = rootV;
        }

        return new int[0];
    }

    /**
     * Find with path compression.
     */
    private int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent, parent[i]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] res1 = sol.findRedundantConnection(edges1);
        System.out.println("Redundant edge 1: [" + res1[0] + "," + res1[1] + "]"); // [2,3]

        int[][] edges2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        int[] res2 = sol.findRedundantConnection(edges2);
        System.out.println("Redundant edge 2: [" + res2[0] + "," + res2[1] + "]"); // [1,4]
    }
}
