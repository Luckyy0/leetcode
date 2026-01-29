package leetcode.P1245_TreeDiameter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] bfs1 = bfs(0, n, adj);
        int u = bfs1[0];

        int[] bfs2 = bfs(u, n, adj);
        return bfs2[1];
    }

    // Returns [farthestNode, distance]
    private int[] bfs(int start, int n, List<List<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        boolean[] visited = new boolean[n];
        visited[start] = true;

        int dist = -1;
        int lastNode = start;

        while (!q.isEmpty()) {
            int size = q.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int u = q.poll();
                lastNode = u;
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
        }

        return new int[] { lastNode, dist };
    }
}
