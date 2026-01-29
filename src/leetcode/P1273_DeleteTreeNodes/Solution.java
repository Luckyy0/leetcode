package leetcode.P1273_DeleteTreeNodes;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nodes; i++)
            adj.add(new ArrayList<>());

        int root = 0;
        for (int i = 0; i < nodes; i++) {
            if (parent[i] != -1) {
                adj.get(parent[i]).add(i);
            } else {
                root = i;
            }
        }

        return dfs(root, adj, value)[1];
    }

    // Returns {sum, count}
    private int[] dfs(int u, List<List<Integer>> adj, int[] value) {
        int sum = value[u];
        int count = 1;

        for (int v : adj.get(u)) {
            int[] res = dfs(v, adj, value);
            sum += res[0];
            count += res[1];
        }

        if (sum == 0) {
            return new int[] { 0, 0 };
        }

        return new int[] { sum, count };
    }
}
