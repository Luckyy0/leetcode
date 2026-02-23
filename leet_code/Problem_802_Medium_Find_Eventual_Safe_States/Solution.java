package leet_code.Problem_802_Medium_Find_Eventual_Safe_States;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Finds all eventual safe nodes.
     * Strategy: DFS with 3 colors (0: unvisited, 1: visiting, 2: safe).
     * Time: O(V + E), Space: O(V).
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(i, graph, color)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSafe(int node, int[][] graph, int[] color) {
        // If already visited, check if it was marked as safe (2)
        if (color[node] > 0) {
            return color[node] == 2;
        }

        // Mark as visiting (1)
        color[node] = 1;

        // Explore all neighbors
        for (int neighbor : graph[node]) {
            // If any neighbor leads to a cycle or is unsafe
            if (!isSafe(neighbor, graph, color)) {
                return false;
            }
        }

        // No cycles found from this node, mark as safe (2)
        color[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
        System.out.println("Result 1: " + sol.eventualSafeNodes(g1)); // [2, 4, 5, 6]

        int[][] g2 = { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {} };
        System.out.println("Result 2: " + sol.eventualSafeNodes(g2)); // [4]
    }
}
