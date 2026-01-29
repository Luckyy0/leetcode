package leetcode.P2003_SmallestMissingGeneticValueInEachSubtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int nodeWith1 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                nodeWith1 = i;
                break;
            }
        }

        if (nodeWith1 == -1)
            return ans;

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            adj[parents[i]].add(i);
        }

        boolean[] seen = new boolean[100002]; // Values
        boolean[] vis = new boolean[n]; // Nodes visited

        int curr = nodeWith1;
        int mex = 1;

        while (curr != -1) {
            // Process subtree of curr, excluding nodes already visited (which is the child
            // we came from)
            dfs(curr, adj, nums, seen, vis);

            // Update mex
            while (seen[mex])
                mex++;
            ans[curr] = mex;

            curr = parents[curr];
        }

        return ans;
    }

    private void dfs(int u, List<Integer>[] adj, int[] nums, boolean[] seen, boolean[] vis) {
        if (vis[u])
            return;
        vis[u] = true;

        if (nums[u] < seen.length)
            seen[nums[u]] = true;

        for (int v : adj[u]) {
            if (!vis[v]) {
                dfs(v, adj, nums, seen, vis);
            }
        }
    }
}
