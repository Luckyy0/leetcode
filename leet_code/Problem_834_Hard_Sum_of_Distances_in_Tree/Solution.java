package leet_code.Problem_834_Hard_Sum_of_Distances_in_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Calculates the sum of distances from each node to all other nodes in a tree.
     * Strategy: Re-rooting DP (two DFS passes).
     * Time: O(N), Space: O(N).
     */
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] count = new int[n]; // Subtree size
        int[] result = new int[n]; // Sum of distances

        // Pass 1: Calculate count[i] and result[i] (subtree distances) for root 0
        dfsPostOrder(0, -1, graph, count, result);

        // Pass 2: Calculate result[i] for all nodes by adjusting relative to parent
        dfsPreOrder(0, -1, n, graph, count, result);

        return result;
    }

    private void dfsPostOrder(int u, int p, List<List<Integer>> graph, int[] count, int[] result) {
        count[u] = 1;
        for (int v : graph.get(u)) {
            if (v == p)
                continue;
            dfsPostOrder(v, u, graph, count, result);
            count[u] += count[v];
            // Total distance to u increases by sum of distances in subtree v
            // PLUS one for each node in subtree v (to travel from v to u)
            result[u] += result[v] + count[v];
        }
    }

    private void dfsPreOrder(int u, int p, int n, List<List<Integer>> graph, int[] count, int[] result) {
        for (int v : graph.get(u)) {
            if (v == p)
                continue;
            // Moving from root u to root v:
            // - result[v] gets closer to count[v] nodes by 1
            // - result[v] gets further from (n - count[v]) nodes by 1
            result[v] = result[u] - count[v] + (n - count[v]);
            dfsPreOrder(v, u, n, graph, count, result);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 6;
        int[][] e1 = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
        System.out.println("Result 1: " + Arrays.toString(sol.sumOfDistancesInTree(n1, e1)));
        // Expect: [8, 12, 6, 10, 10, 10]
    }
}
