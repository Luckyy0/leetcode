package leetcode.P1519_NumberOfNodesInTheSubTreeWithTheSameLabel;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] res = new int[n];
        dfs(0, -1, adj, labels, res);
        return res;
    }

    private int[] dfs(int u, int p, List<List<Integer>> adj, String labels, int[] res) {
        int[] count = new int[26];
        count[labels.charAt(u) - 'a'] = 1;

        for (int v : adj.get(u)) {
            if (v == p)
                continue;
            int[] childCount = dfs(v, u, adj, labels, res);
            for (int i = 0; i < 26; i++) {
                count[i] += childCount[i];
            }
        }

        res[u] = count[labels.charAt(u) - 'a'];
        return count;
    }
}
