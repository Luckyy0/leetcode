package leetcode.P261_GraphValidTree;

public class Solution {

    /**
     * Problem 261: Graph Valid Tree
     * Approach: Union-Find
     * 
     * Theoretical Basis:
     * - Tree must have N-1 edges and no cycles.
     * - Or N-1 edges and fully connected.
     * 
     * Time Complexity: O(N * alpha(N))
     * Space Complexity: O(N)
     */
    public boolean validTree(int n, int[][] edges) {
        // Condition 1: Number of edges must be n - 1
        if (edges.length != n - 1) {
            return false;
        }

        // Condition 2: No cycles (checked via Union-Find)
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            int rootX = find(parent, edge[0]);
            int rootY = find(parent, edge[1]);

            if (rootX == rootY) {
                return false; // Cycle detected
            }

            parent[rootX] = rootY; // Union
        }

        // If we processed n-1 edges without cycle, the graph must be connected.
        return true;
    }

    private int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]); // Path compression
        }
        return parent[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // n=5, edges=[[0,1],[0,2],[0,3],[1,4]] -> true
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 4 } };
        runTest(solution, 5, edges1, true);

        // n=5, edges=[[0,1],[1,2],[2,3],[1,3],[1,4]] -> false (cycle 1-2-3-1)
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 } };
        runTest(solution, 5, edges2, false);
    }

    private static void runTest(Solution s, int n, int[][] edges, boolean expected) {
        boolean result = s.validTree(n, edges);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
