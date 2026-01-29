package leetcode.P847_ShortestPathVisitingAllNodes;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        if (n == 1)
            return 0;

        int targetMask = (1 << n) - 1;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][targetMask + 1];

        for (int i = 0; i < n; i++) {
            queue.add(new int[] { i, 1 << i });
            visited[i][1 << i] = true;
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0], mask = curr[1];

                if (mask == targetMask)
                    return steps;

                for (int v : graph[u]) {
                    int nextMask = mask | (1 << v);
                    if (!visited[v][nextMask]) {
                        visited[v][nextMask] = true;
                        queue.add(new int[] { v, nextMask });
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}
