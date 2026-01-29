package leetcode.P2050_ParallelCoursesIII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            adj[i] = new ArrayList<>();
        int[] inDegree = new int[n + 1];

        for (int[] r : relations) {
            adj[r[0]].add(r[1]);
            inDegree[r[1]]++;
        }

        int[] dist = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                dist[i] = time[i - 1]; // time is 0-indexed
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                dist[v] = Math.max(dist[v], dist[u] + time[v - 1]);
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++)
            maxTime = Math.max(maxTime, dist[i]);
        return maxTime;
    }
}
