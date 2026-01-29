package leetcode.P2045_SecondMinimumTimeToReachDestination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // Find 1st and 2nd shortest path length (number of edges)
        // dist[i][0] is min edges, dist[i][1] is 2nd min edges (strictly > min)
        int[][] dist = new int[n + 1][2];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] { 1, 0 });
        dist[1][0] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0];
            int d = curr[1];

            // Try neighbors
            // If d is larger than stored 2nd min, prune?
            // Actually standard BFS logic for k-shortest

            int newD = d + 1;
            for (int v : adj[u]) {
                if (newD < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = newD;
                    q.offer(new int[] { v, newD });
                } else if (newD > dist[v][0] && newD < dist[v][1]) {
                    dist[v][1] = newD;
                    q.offer(new int[] { v, newD });
                }
            }
        }

        int steps = dist[n][1];
        return calculateTime(steps, time, change);
    }

    private int calculateTime(int steps, int time, int change) {
        int currTime = 0;
        for (int i = 0; i < steps; i++) {
            // Check light at start of edge (node arrival time)
            // Cycle 2*change.
            // If green: [2k*change, (2k+1)*change)
            // If red: [(2k+1)*change, (2k+2)*change)
            // If currTime is in red, wait.

            int cycle = currTime / change;
            if (cycle % 2 == 1) { // Red
                int wait = (cycle + 1) * change - currTime;
                currTime += wait;
            }

            currTime += time;
        }
        return currTime;
    }
}
