package leetcode.P1466_ReorderRoutesToMakeAllPathsLeadToCityZero;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] c : connections) {
            adj.get(c[0]).add(new int[] { c[1], 1 }); // Original direction 0->1 cost 1 to flip?
            // Wait. If edge is 0->1. We are at 0, going to 1. To make 1 reach 0, we need
            // 1->0.
            // Current is 0->1. We need to flip. So cost 1.
            // If edge is 1->0. We are at 0, going to 1 (conceptually traversing tree).
            // Current is 1->0. This is good. Cost 0.

            adj.get(c[1]).add(new int[] { c[0], 0 }); // Reverse direction cost 0
        }

        return dfs(0, -1, adj);
    }

    private int dfs(int u, int parent, List<List<int[]>> adj) {
        int count = 0;
        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int cost = edge[1];
            if (v != parent) {
                count += cost + dfs(v, u, adj);
            }
        }
        return count;
    }
}
