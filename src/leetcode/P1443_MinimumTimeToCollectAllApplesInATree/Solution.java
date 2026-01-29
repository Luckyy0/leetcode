package leetcode.P1443_MinimumTimeToCollectAllApplesInATree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, hasApple, visited);
    }

    // Returns the cost to collect apples in the subtree rooted at u (not including
    // edge to parent)
    private int dfs(int u, List<List<Integer>> graph, List<Boolean> hasApple, boolean[] visited) {
        visited[u] = true;
        int totalTime = 0;

        for (int v : graph.get(u)) {
            if (visited[v])
                continue;

            int childTime = dfs(v, graph, hasApple, visited);

            // If childTime > 0, it means subtree has apples.
            // If hasApple[v] is true, v itself has apple.
            if (childTime > 0 || hasApple.get(v)) {
                totalTime += childTime + 2;
            }
        }

        return totalTime;
    }
}
