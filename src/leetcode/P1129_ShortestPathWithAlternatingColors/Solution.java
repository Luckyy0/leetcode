package leetcode.P1129_ShortestPathWithAlternatingColors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] redAdj = new ArrayList[n];
        List<Integer>[] blueAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }
        for (int[] e : redEdges)
            redAdj[e[0]].add(e[1]);
        for (int[] e : blueEdges)
            blueAdj[e[0]].add(e[1]);

        // dist[i][0] -> min dist to i arriving with RED edge
        // dist[i][1] -> min dist to i arriving with BLUE edge
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dist[i], -1);

        Queue<int[]> q = new LinkedList<>();
        // Start node 0, distance 0.
        // Can simulate "arrived with BLUE" (to allow RED next) and "arrived with RED"
        // (to allow BLUE next)
        // Let's use 0 for RED, 1 for BLUE.
        q.add(new int[] { 0, 0, 0 }); // Node 0, color RED (so prev edge was RED? No wait: color used to reach this.)
        // Actually, if we say state is (u, c), let c be the color of the edge used to
        // reach u.
        // For node 0, we used NO edge.
        // So allow both next.
        // Push (0, 0) and (0, 1)? Use sentinel color -1?
        // Let's push targets of 0 manually? Or easier:
        // Use dist[0][0] = 0, dist[0][1] = 0.
        // Push (0, 0) and (0, 1).
        // 0=RED, 1=BLUE.
        // If state is 0 (RED), next edges must be BLUE.
        // If state is 1 (BLUE), next edges must be RED.

        dist[0][0] = 0;
        dist[0][1] = 0;
        q.add(new int[] { 0, 0 }); // Last edge RED
        q.add(new int[] { 0, 1 }); // Last edge BLUE

        // Wait, dist[0][0] = 0 means reached 0 via RED edge.
        // But we didn't.
        // The distance is number of edges.
        // If we reach 0 with length 0, last edge undefined.
        // So neighbors of 0 can be reached if we treat 0 as being reached by "virtual
        // blue" (to take red) and "virtual red" (to take blue).

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int lastColor = curr[1];
            int d = dist[u][lastColor];

            // If lastColor was RED (0), next must be BLUE (from blueAdj)
            if (lastColor == 0) {
                for (int v : blueAdj[u]) {
                    if (dist[v][1] == -1) {
                        dist[v][1] = d + 1;
                        q.add(new int[] { v, 1 });
                    }
                }
            }
            // If lastColor was BLUE (1), next must be RED
            if (lastColor == 1) {
                for (int v : redAdj[u]) {
                    if (dist[v][0] == -1) {
                        dist[v][0] = d + 1;
                        q.add(new int[] { v, 0 });
                    }
                }
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int r = dist[i][0];
            int b = dist[i][1];
            if (r == -1 && b == -1)
                ans[i] = -1;
            else if (r == -1)
                ans[i] = b;
            else if (b == -1)
                ans[i] = r;
            else
                ans[i] = Math.min(r, b);
        }
        return ans;
    }
}
