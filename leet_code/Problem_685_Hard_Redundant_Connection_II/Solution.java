package leet_code.Problem_685_Hard_Redundant_Connection_II;

public class Solution {

    /**
     * Finds the redundant edge in a directed graph to restore a rooted tree.
     * Strategy: Handling two-parent nodes and cycle detection using Union-Find.
     * Time: O(N * alpha(N)), Space: O(N).
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] cand1 = null;
        int[] cand2 = null;

        // 1. Check for node with two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != 0) {
                // Node v already has a parent, these are the two candidates
                cand1 = new int[] { parent[v], v };
                cand2 = new int[] { u, v };
                break;
            }
            parent[v] = u;
        }

        // 2. Cycle detection using Union-Find
        int[] dsuParent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            dsuParent[i] = i;

        for (int[] edge : edges) {
            // Temporary skip the second candidate to see if it fixes the problem
            if (cand2 != null && edge[0] == cand2[0] && edge[1] == cand2[1])
                continue;

            int rootU = find(dsuParent, edge[0]);
            int rootV = find(dsuParent, edge[1]);

            if (rootU == rootV) {
                // Cycle found
                if (cand1 == null) {
                    // Scenario: No two-parent node, just a cycle
                    return edge;
                } else {
                    // Scenario: Indegree 2 + Cycle. Skipping cand2 wasn't enough.
                    // This means cand1 must be the one within the cycle.
                    return cand1;
                }
            }
            dsuParent[rootU] = rootV;
        }

        // No cycle found while skipping cand2, so cand2 is the answer
        return cand2;
    }

    private int find(int[] dsuParent, int i) {
        if (dsuParent[i] == i)
            return i;
        return dsuParent[i] = find(dsuParent, dsuParent[i]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[] res1 = sol.findRedundantDirectedConnection(edges1);
        System.out.println("Result 1: [" + res1[0] + "," + res1[1] + "]"); // [2,3]

        int[][] edges2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 }, { 1, 5 } };
        int[] res2 = sol.findRedundantDirectedConnection(edges2);
        System.out.println("Result 2: [" + res2[0] + "," + res2[1] + "]"); // [4,1]
    }
}
