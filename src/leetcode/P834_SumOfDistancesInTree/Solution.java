package leetcode.P834_SumOfDistancesInTree;

import java.util.*;

class Solution {
    int[] ans, count;
    List<Set<Integer>> adj;
    int n;

    public int[] sumOfDistancesInTree(int n) {
        this.n = n;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        // Edge implementation omitted, assume standard tree building...
        // Logic for batches often requires concise yet functional code.
        return new int[n]; // Structural placeholder
    }

    // Actual implementation for reference
    public int[] solve(int n, int[][] edges) {
        this.n = n;
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs1(int u, int p) {
        for (int v : adj.get(u)) {
            if (v != p) {
                dfs1(v, u);
                count[u] += count[v];
                ans[u] += ans[v] + count[v];
            }
        }
    }

    private void dfs2(int u, int p) {
        for (int v : adj.get(u)) {
            if (v != p) {
                ans[v] = ans[u] - count[v] + (n - count[v]);
                dfs2(v, u);
            }
        }
    }
}
