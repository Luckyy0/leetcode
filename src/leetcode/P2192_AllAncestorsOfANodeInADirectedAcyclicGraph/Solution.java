package leetcode.P2192_AllAncestorsOfANodeInADirectedAcyclicGraph;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, i, adj, visited, res);
        }

        return res;
    }

    private void dfs(int ancestor, int curr, List<List<Integer>> adj, boolean[] visited, List<List<Integer>> res) {
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                res.get(neighbor).add(ancestor);
                dfs(ancestor, neighbor, adj, visited, res);
            }
        }
    }
}
