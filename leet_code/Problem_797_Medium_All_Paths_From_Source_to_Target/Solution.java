package leet_code.Problem_797_Medium_All_Paths_From_Source_to_Target;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Finds all paths from node 0 to node n-1 in a DAG.
     * Strategy: Backtracking (DFS).
     * Time: O(2^N * N), Space: O(2^N * N).
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0); // Start from node 0
        dfs(graph, 0, path, result);
        return result;
    }

    private void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        // Base case: if current node is the target (n-1)
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(path)); // Add a copy of the current path
            return;
        }

        // Recursive step: explore neighbors
        for (int neighbor : graph[node]) {
            path.add(neighbor); // Choose neighbor
            dfs(graph, neighbor, path, result); // Recurse
            path.remove(path.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 1, 2 }, { 3 }, { 3 }, {} };
        System.out.println("Result 1: " + sol.allPathsSourceTarget(g1));
        // Expected: [[0, 1, 3], [0, 2, 3]]

        int[][] g2 = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
        System.out.println("Result 2: " + sol.allPathsSourceTarget(g2));
        // Expected: [[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]
    }
}
